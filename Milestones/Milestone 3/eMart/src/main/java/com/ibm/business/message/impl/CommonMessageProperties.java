package com.ibm.business.message.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ibm.business.message.Message;
import com.ibm.business.message.MessageLevel;
import com.ibm.business.message.MessageProperties;

/**
 * メッセージ管理するコンポーネント
 *
 */
@Component
public class CommonMessageProperties implements MessageProperties {
    /** ロガー */
    private static final Logger logger = LogManager.getLogger(CommonMessageProperties.class);

    /** メッセージマップ */
    private static Map<String, CommonMessage> messages = new ConcurrentHashMap<String, CommonMessage>();

    /**
     * コンストラクター
     */
    public CommonMessageProperties() {

    }

    public static Message loadMessage(String messageId) {
        Message message = messages.get(messageId);
        if (message == null) {
            logger.error("message.propertiesに定義しないメッセージID:" + messageId);
            throw new IllegalArgumentException("message.propertiesに定義しないメッセージID:" + messageId);
        }
        return message;
    }
    
    /**
     * メッセージIDよりメッセージを取得
     */
    @Override
    public Message getMessage(String messageId) {
        Message message = messages.get(messageId);
        if (message == null) {
            logger.error("message.propertiesに定義しないメッセージID:" + messageId);
            throw new IllegalArgumentException("message.propertiesに定義しないメッセージID:" + messageId);
        }
        return message;
    }

    /**
     * メッセージIDよりメッセージを取得
     */
    @Override
    public Message getMessage(String messageId, Object... arguments) {
        Message message = getMessage(messageId);
        message = format(message, arguments);
        return message;
    }

    @Override
    public boolean hasMessageId(String messageId) {
        return messages.containsKey(messageId);
    }

    /**
     * メッセージをフォーマットする
     * @param message メッセージ
     * @param arguments パラメータ
     * @return メッセージ
     */
    protected Message format(Message message, Object[] arguments) {
        CommonMessage newMessage = new CommonMessage();
        // メッセージID
        newMessage.setMessageID(message.getMessageID());
        // ログレベル
        newMessage.setLevel(message.getLevel());
        // HttpStatusCode
        newMessage.setHttpStatusCode(message.getHttpStatusCode());
        // メッセージ
        String msg = MessageFormat.format(message.getMessage(), arguments);
        newMessage.setMessage(msg);
        return newMessage;
    }

    @PostConstruct
    public void init() throws IOException {
        InputStream in =
                CommonMessageProperties.class.getResourceAsStream("/message.properties");
        Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
        Properties props = new Properties();
        try {
            props.load(reader);
        } catch (IOException e) {
            logger.error("メッセージmessage.propertiesを読み込み失敗", e);
            throw e;
        }
        Map<String, CommonMessage> map = new HashMap<String, CommonMessage>();
        // メッセージタイプをチェックする
        Iterator<Object> keyIter = props.keySet().iterator();
        while (keyIter.hasNext()) {
            String messageID = (String) keyIter.next();
            String message = props.getProperty(messageID);
            String[] msgList = message.split("\\,", 3);
            CommonMessage commonMessage = new CommonMessage();
            if (msgList.length != 3) {
                logger.error("識別できないメッセージID:" + messageID + ", メッセージ:" + message);
                throw new IOException("識別できないメッセージID:" + messageID + ", メッセージ:" + message);
            }
            // メッセージID
            commonMessage.setMessageID(messageID);
            // ログレベル
            String logLevel = msgList[0];
            try {
                MessageLevel level = MessageLevel.valueOf(logLevel);
                commonMessage.setLevel(level);
            } catch (RuntimeException e) {
                logger.error("識別できないメッセージID:" + messageID + ", メッセージ:" + message + ", 無効のログレベル",
                        e);
                throw e;
            }
            // HttpStatusCode
            int httpStatusCode = 0;
            try {
                httpStatusCode = Integer.parseInt(msgList[1]);
                commonMessage.setHttpStatusCode(httpStatusCode);
            } catch (NumberFormatException e) {
                logger.error("識別できないメッセージID:" + messageID + ", メッセージ:" + message
                        + ", 無効のHTTPStatusCode", e);
                throw e;
            }
            // メッセージ
            commonMessage.setMessage(msgList[2]);
            // マップに格納する
            map.put(messageID, commonMessage);
        }
        messages = Collections.unmodifiableMap(map);
    }

}
