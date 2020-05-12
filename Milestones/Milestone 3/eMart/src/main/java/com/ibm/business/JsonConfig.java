package com.ibm.business;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON解析用配置
 *
 */
@Configuration
public class JsonConfig {

    /**
     * オブジェクト・マッパーを提供
     * @return オブジェクト・マッパー
     */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // NULL対象を出力しない
        mapper.setSerializationInclusion(Include.NON_NULL);
        return mapper;
    }

}
