package com.ibm.business.constant;

/**
* BFFDigital
* @author ShiYan May 11, 2019
* © Copyright IBM Corp. 2019 All rights reserved.
**/

public class SwaggerConstant {

    public static final String HTML_PATH = "/swagger-ui.html";
    public static final String DOC_PATH = "/v2/api-docs";
    public static final String WEB_JARS_PATH = "/webjars";
    public static final String SWAGGER_RESOURCES_PATH = "/swagger-resources";
    public static final String CSRF = "/csrf";
    public static final String ERROR = "/error";
    public static final String[] SWAGGER_PATHS =
            {HTML_PATH, DOC_PATH + "/**", WEB_JARS_PATH + "/**", SWAGGER_RESOURCES_PATH + "/**",
                    CSRF + "/**", ERROR + "/**", "/"};


    /** HTTPStatusCode(200 SUCCESS) 業務定義文字列 */
    public static final String COMMON_HTTP_200_RES_DESC_MESSAGE = "正常終了";

    /** HTTPStatusCode(400 BAD REQUEST) エラー業務定義文字列 */
    public static final String COMMON_HTTP_400_RES_DESC_MESSAGE = "{0}は入力必須項目です。(E000000002000)<br>" + //
            "項目 {0} は {1} から {2} 文字である必要があります。(E000000002001)<br>" + //
            "項目 {0} は {1} である必要があります。(E000000002002)<br>" + //
            "項目 {0} は {1} 文字である必要があります。(E000000002003)";

    /** HTTPStatusCode(401 UNAUTHORIZED) エラー業務定義文字列 */
    public static final String COMMON_HTTP_401_RES_DESC_MESSAGE =
            "アクセス・トークンが不正もしくは失効しました。(E000000001000)<br>" + //
                    "AppSecretが不正もしくは失効しました。(E000000001001)";

    /** HTTPStatusCode(426 UPGRADE_REQUIRED) エラー業務定義文字列 */
    public static final String COMMON_HTTP_426_RES_ERROR_DESC =
            "アプリケーションのアップデートが必要です。(E000000001002)";

    /** HTTPStatusCode(500 INTERNAL_SERVER_ERROR) エラー業務定義文字列 */
    public static final String COMMON_HTTP_500_RES_DESC_MESSAGE =
            "システムエラーが発生しました。只今対応しております、しばらくお待ちください。(E000000000000)<br>" + //
                    "ヘッダー部に{0}が必須項目です。(E000000002004)<br>" + //
                    "システムエラーが発生しました。只今対応しております、しばらくお待ちください。(E000000003000)<br>" + //
                    "リモートサービスとの通信で予期しないエラーが発生しました。(E000000004000)<br>" + //
                    "リモートサービスとの通信に失敗しました。(E000000004001)<br>" + //
                    "リモートサービスが処理エラーが発生しました。(E000000004004)<br>" + //
                    "リモートサービスが認識できないデータフォーマットを返しました。(E000000004005)";

}
