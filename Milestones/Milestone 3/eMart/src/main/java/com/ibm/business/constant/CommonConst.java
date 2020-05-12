// © Copyright IBM Corp. 2017 All rights reserved.
package com.ibm.business.constant;

public class CommonConst {

	// Swagger
	public static final String SWAGGER_TITLE = "Mobile Passbook API";

	public static final String SWAGGER_VERSION = "1.0.0";

	public static final String SWAGGER_DESCRIPTION = "Mobile PassbookのBFF(Backend for Frotend)　Serverが提供するAPIです。<br>"
			+ "<br>" + "エラー応答に関して、記載しているエラーについてはモバイルアプリで個別にハンドリングが必須です。<br>"
			+ "記載しているエラー以外の応答の可能性がありますが、発生の場合にはシステムエラーとして処理すること。<br>" + "<br>";

	// Regex
	public static final String REGEXP_ALP_HALF = "^[a-zA-Z]*$";

	public static final String REGEXP_DIGIT_ALP_HALF = "^[0-9a-zA-Z]*$";

	public static final String REGEXP_DIGIT_ALP_HALF_DESCRIPTION = "半角英数字";

	public static final String REGEXP_DIGIT_HALF = "^[0-9]*$";

	public static final String REGEXP_ASCII = "^[\\x20-\\x7E]*$";

	public static final String REGEXP_DIGIT_HALF_DOT = "^[0-9¥.]*$";

	public static final String REGEXP_KANA = "^[ァ-ン]*$";

	public static final String REGEXP_FULLDATE_RFC3339 = "^[0-9]{4,4}-[0-9]{2,2}-[0-9]{2,2}$";

	// API Parameters
	/** api charset */
	public static final String API_CHARSET = "UTF-8";

	/** errorCode */
	public static final String API_PARAM_ERRORCODE_VALUE = "エラーコード";

	public static final String API_PARAM_ERRORCODE_EXAMPLE = "E000100000";

	/** errorMessage */
	public static final String API_PARAM_ERRORMESSAGE_VALUE = "エラーメッセージ";

	public static final String API_PARAM_ERRORMESSAGE_EXAMPLE = "口座番号を入力してください。";

	/** Access Token Header Name */
	public static final String API_PARAM_PBK_AUTH_HEADER_NAME = "X-PBK-AUTH";

	/** registration flag */
	public static final String API_PARAM_REG_TYPE_VALUE = "regFlag";

	public static final int API_PARAM_REG_TYPE_LEN = 1;

	public static final String API_PARAM_REG_TYPE_PATTERN = REGEXP_DIGIT_HALF;

	public static final String API_PARAM_REG_TYPE_DESCRIPTION = "半角数字 1桁 0(初回) 1(2回目以降)";

	/** device id */
	public static final String API_PARAM_DEVICE_ID_VALUE = "deviceId";

	public static final int API_PARAM_DEVICE_ID_LEN = 36;

	public static final String API_PARAM_DEVICE_ID_PATTERN = "^[0-9a-zA-Z-]*$";

	public static final String API_PARAM_DEVICE_ID_DESCRIPTION = "半角英数字ハイフン 36桁";

	/** password */
	public static final String API_PARAM_APPSECRET_VALUE = "appSecret";

	public static final int API_PARAM_APPSECRET_LEN = 64;

	public static final String API_PARAM_APPSECRET_PATTERN = REGEXP_DIGIT_ALP_HALF;

	public static final String API_PARAM_APPSECRET_LEN_DESCRIPTIOIN = "半角英数字 64桁";

	/** os */
	public static final String API_PARAM_OS_VALUE = "os";

	public static final int API_PARAM_OS_LEN = 1;

	public static final String API_PARAM_OS_PATTERN = REGEXP_DIGIT_HALF;

	public static final String API_PARAM_OS_DESCRIPTION = "半角数字 1桁 0(IOS) 1(Android)";

	/** osVersion */
	public static final String API_PARAM_OSVERSION_VALUE = "osVersion";

	public static final int API_PARAM_OSVERSION_LEN_MIN = 1;

	public static final int API_PARAM_OSVERSION_LEN_MAX = 15;

	public static final String API_PARAM_OSVERSION_DESCRIPTION = "1-15桁(bytes)";

	/** appVersion */
	public static final String API_PARAM_APPVERSION_VALUE = "appVersion";

	public static final int API_PARAM_APPVERSION_LEN_MIN = 1;

	public static final int API_PARAM_APPVERSION_LEN_MAX = 15;

	public static final String API_PARAM_APPVERSION_DESCRIPTION = "1-15桁(bytes)";

	/** device name */
	public static final String API_PARAM_DEVICE_NAME_VALUE = "deviceName";

	public static final int API_PARAM_DEVICE_LEN_MAX = 100;

	public static final String API_PARAM_DEVICE_PATTERN = REGEXP_ASCII;

	public static final String API_PARAM_DEVICE_DESCRIPTION = "1-100文字(bytes)(桁数超過は削除)　半角文字(ASCII)";

	/** Authorization Header Name */
	public static final String API_PARAM_PBK_AUTHORIZATION_HEADER_VALUE = "Basic認証ヘッダー";

	public static final String API_PARAM_PBK_AUTHORIZATION_HEADER_NAME = "Authorization";

	public static final String API_PARAM_PBK_AUTHORIZATION_HEADER_EXAMPLE = "Basic VRQVR210SFSDBFWA";

	public static final String API_PARAM_PBK_AUTHORIZATION_HEADER_DESCRIPTION = "Basic {" + API_PARAM_REG_TYPE_VALUE
			+ "}&{" + API_PARAM_DEVICE_ID_VALUE + "}&{" + API_PARAM_OS_VALUE + "}&{" + API_PARAM_OSVERSION_VALUE + "}&{"
			+ API_PARAM_APPVERSION_VALUE + "}&{" + API_PARAM_DEVICE_NAME_VALUE + "}:{" + API_PARAM_APPSECRET_VALUE
			+ "}";

	/** BFF AccessToken */
	public static final String API_PARAM_BFF_ACCESSTOKEN_VALUE = "BFFアクセス・トークン";

	public static final String API_PARAM_BFF_ACCESSTOKEN_EXAMPLE = "b2db9806bf53fdc3e84ba4c54fe9304195eb5776e0f34801954d973173516d2f";

	public static final String API_PARAM_BFF_ACCESSTOKEN_DESCRIPTION = "64桁 半角英数字";

	public static final int API_PARAM_BFF_ACCESSTOKEN_LEN = 64;

	public static final String API_PARAM_BFF_ACCESSTOKEN_PATTERN = REGEXP_DIGIT_ALP_HALF;

	/** PBK Auth AccessToken Header */
	public static final String API_PARAM_PBK_AUTH_HEADER_VALUE = "BFFアクセス・トークン";

	public static final String API_PARAM_PBK_AUTH_HEADER_EXAMPLE = "b2db9806bf53fdc3e84ba4c54fe9304195eb5776e0f34801954d973173516d2f";

	public static final String API_PARAM_PBK_AUTH_HEADER_DESCRIPTION = API_PARAM_BFF_ACCESSTOKEN_DESCRIPTION;

	/** OAuth Redirect */
	public static final String API_PARAM_AUTHENTICATION = "auth";

	/** OAuth token */
	public static final String API_PARAM_TOKEN = "token";

	/** OAuth code */
	public static final String API_PARAM_CODE = "code";

	public static final String API_PARAM_CODE_VALUE = "認可コード";

	public static final String API_PARAM_CODE_EXAMPLE = "FDSACT230T1RFSFEWA9EGGFNAFWEWRW39";

	public static final String API_PARAM_CODE_PATTERN = "1-1500桁";

	public static final int API_PARAM_CODE_LEN_MIN = 1;

	public static final int API_PARAM_CODE_LEN_MAX = 1500;

	/** OAuth state */
	public static final String API_PARAM_STATE = "state";

	public static final String API_PARAM_STATE_VALUE = "ステート";

	public static final String API_PARAM_STATE_EXAMPLE = "VDS2qbcVDSrhwFDSAW4aurxR29bfew";

	public static final String API_PARAM_STATE_DESCRIPTION = "64桁 半角英数字";

	public static final int API_PARAM_STATE_LEN = 64;

	public static final String API_PARAM_REDIRECTIONURL = "callback";

	public static final String API_PARAM_MEMOS = "memos";

	public static final String API_PARAM_TRANSACTIONS = "transactions";

	/** Accounts */
	public static final String API_PARAM_ACCOUNTS = "accounts";

	public static final String API_PARAM_ACCOUNTS_VALUE = "口座一覧";

	/** AccountToken */
	public static final String API_PARAM_ACCOUNTTOKEN = "accountToken";

	public static final String API_PARAM_ACCOUNTTOKEN_VALUE = "口座トークン";

	public static final String API_PARAM_ACCOUNTTOKEN_PATTERN = REGEXP_DIGIT_ALP_HALF;

	public static final String API_PARAM_ACCOUNTTOKEN_EXAMPLE = "12345FEWAGWdfsE67ga";

	public static final String API_PARAM_ACCOUNTTOKEN_DESCRIPTION = "64桁 半角英数字";

	public static final int API_PARAM_ACCOUNTTOKEN_LEN = 64;

	/** AccountName */
	public static final String API_PARAM_ACCOUNTNAME = "accountName";

	public static final String API_PARAM_ACCOUNTNAME_VALUE = "口座名(ｶﾅ)";

	public static final String API_PARAM_ACCOUNTNAME_PATTERN = REGEXP_KANA;

	public static final String API_PARAM_ACCOUNTNAME_EXAMPLE = "ﾊｺｻﾞｷﾀﾛｳ";

	public static final String API_PARAM_ACCOUNTNAME_DESCRIPTION = "1-71桁 半角ｶﾅ英字";

	/** accountKanjiName */
	public static final String API_PARAM_ACCOUNTKANJINAME = "accountKanjiName";

	public static final String API_PARAM_ACCOUNTKANJINAME_VALUE = "口座名(漢字)";

	public static final String API_PARAM_ACCOUNTKANJINAME_EXAMPLE = "箱崎太郎";

	public static final String API_PARAM_ACCOUNTKANJINAME_DESCRIPTION = "0-71桁 全角すべて";

	/** AccountType */
	public static final String API_PARAM_ACCOUNTTYPE = "accountType";

	public static final String API_PARAM_ACCOUNTTYPE_VALUE = "科目コード";

	public static final String API_PARAM_ACCOUNTTYPE_EXAMPLE = "00";

	public static final String API_PARAM_ACCOUNTTYPE_DESCRIPTION = "2桁 半角数字";

	/** AccountTypeName */
	public static final String API_PARAM_ACCOUNTTYPENAME_VALUE = "科目名";

	public static final String API_PARAM_ACCOUNTTYPENAME_EXAMPLE = "普通";

	public static final String API_PARAM_ACCOUNTTYPENAME_DESCRIPTION = "1-8桁 全角すべて";

	/** AccountNumber */
	public static final String API_PARAM_ACCOUNNUMBER = "accountNumber";

	public static final String API_PARAM_ACCOUNNUMBER_VALUE = "口座番号";

	public static final String API_PARAM_ACCOUNNUMBER_EXAMPLE = "0123456";

	public static final String API_PARAM_ACCOUNNUMBER_DESCRIPTION = "7桁 半角数字";

	/** branchNumber */
	public static final String API_PARAM_BRANCHNUMBER = "branchNumber";

	public static final String API_PARAM_BRANCHNUMBER_VALUE = "店番";

	public static final String API_PARAM_BRANCHNUMBER_EXAMPLE = "0000001";

	public static final String API_PARAM_BRANCHNUMBER_DESCRIPTION = "7桁 半角数字";

	/** branchName */
	public static final String API_PARAM_BRANCHNAME = "branchName";

	public static final String API_PARAM_BRANCHNAME_VALUE = "店名（ｶﾅ）";

	public static final String API_PARAM_BRANCHNAME_EXAMPLE = "ﾊｺｻﾞｷ";

	public static final String API_PARAM_BRANCHNAME_DESCRIPTION = "1-15桁 半角ｶﾅ";

	/** branchName */
	public static final String API_PARAM_BRANCHKANJINAME = "branchKanjiName";

	public static final String API_PARAM_BRANCHKANJINAME_VALUE = "店名(漢字)";

	public static final String API_PARAM_BRANCHKANJINAME_EXAMPLE = "箱崎";

	public static final String API_PARAM_BRANCHKANJINAME_DESCRIPTION = "1-15桁";

	/** currencyCode */
	public static final String API_PARAM_CURRENCYCODE = "currencyCode";

	public static final String API_PARAM_CURRENCYCODE_VALUE = "通貨コード　'003'日本円固定";

	public static final String API_PARAM_CURRENCYCODE_EXAMPLE = "003";

	public static final String API_PARAM_CURRENCYCODE_DESCRIPTION = "3桁　半角数字";

	/** current amount */
	public static final String API_PARAM_CURRENTAMOUNT = "currentAmount";

	public static final String API_PARAM_CURRENTAMOUNT_VALUE = "残高";

	public static final String API_PARAM_CURRENTAMOUNT_EXAMPLE = "70000";

	public static final String API_PARAM_CURRENTAMOUNT_DESCRIPTION = "1-17桁 半角数字";

	/** dateOfBirth */
	public static final String API_PARAM_DATEOFBIRTH = "dateOfBirth";

	public static final String API_PARAM_DATEOFBIRTH_VALUE = "生年月日";

	public static final String API_PARAM_DATEOFBIRTH_PATTERN = REGEXP_FULLDATE_RFC3339;

	public static final String API_PARAM_DATEOFBIRTH_EXAMPLE = "1989-01-01";

	/** shortPhoneNumber */
	public static final String API_PARAM_SHORTPHONENUMBER = "shortPhoneNumber";

	public static final String API_PARAM_SHORTPHONENUMBER_VALUE = "電話番号（下４桁）";

	public static final String API_PARAM_SHORTPHONENUMBER_PATTERN = REGEXP_DIGIT_HALF;

	public static final String API_PARAM_SHORTPHONENUMBER_EXAMPLE = "8901";

	/** transactionId */
	public static final String API_PARAM_MEMO = "memo";

	public static final String API_PARAM_MEMO_VALUE = "取引明細メモ";

	public static final String API_PARAM_MEMO_EXAMPLE = "父の日プレゼント";

	public static final String API_PARAM_MEMO_DESCRIPTION = "1-100桁";

	public static final int API_PARAM_MEMO_LEN_MIN = 1;

	public static final int API_PARAM_MEMO_LEN_MAX = 100;

	/** transactionId */
	public static final String API_PARAM_UPDATEDAT = "updatedAt";

	public static final String API_PARAM_UPDATEDAT_VALUE = "更新日時";

	public static final String API_PARAM_UPDATEDAT_DESCRIPTION = "25桁 yyyy-MM-dd'T'HH:mm:ssXXX";

	public static final String API_PARAM_UPDATEDAT_EXAMPLE = "2017-07-01T15:21:03+09:00";

	/** memo hasNext */
	public static final String API_PARAM_MEMO_HASNEXT = "hasNext";

	public static final String API_PARAM_MEMO_HASNEXT_VALUE = "未取得のメモ有無";

	public static final String API_PARAM_MEMO_HASNEXT_EXAMPLE = "true";

	/** memo nextMemoParam */
	public static final String API_PARAM_NEXTMEMOPARAM = "nextMemoParam";

	public static final String API_PARAM_NEXTMEMOPARAM_VALUE = "次メモ取得パラメータ";

	public static final String API_PARAM_NEXTMEMOPARAM_EXAMPLE = "00202016102000111";

	public static final String API_PARAM_NEXTMEMOPARAM_DESCRIPTION = "17桁 半角数字";

	public static final int API_PARAM_NEXTMEMOPARAM_LEN = 17;

	/** transactionId */
	public static final String API_PARAM_TRANSACTIONID = "transactionId";

	public static final String API_PARAM_TRANSACTIONID_VALUE = "異動明細番号";

	public static final String API_PARAM_TRANSACTIONID_EXAMPLE = "00123";

	public static final String API_PARAM_TRANSACTIONID_EXAMPLE_PATTERN = REGEXP_DIGIT_HALF;

	public static final String API_PARAM_TRANSACTIONID_DESCRIPTION = "5桁 半角数字";

	public static final int API_PARAM_TRANSACTIONID_LEN = 5;

	/** transactionId */
	public static final String API_PARAM_TRANSACTION_TRANSACTIONDATE = "transactionDate";

	public static final String API_PARAM_TRANSACTION_TRANSACTIONDATE_VALUE = "取引日";

	public static final String API_PARAM_TRANSACTION_TRANSACTIONDATE_EXAMPLE = "2017-06-19";

	public static final String API_PARAM_TRANSACTION_TRANSACTIONDATE_DESCRIPTION = "10桁 yyyy-MM-dd";

	/** withdrawalAmount */
	public static final String API_PARAM_TRANSACTION_WITHDRAWALAMOUNT = "withdrawalAmount";

	public static final String API_PARAM_TRANSACTION_WITHDRAWALAMOUNT_VALUE = "支払金額";

	public static final String API_PARAM_TRANSACTION_WITHDRAWALAMOUNT_EXAMPLE = "8300";

	public static final String API_PARAM_TRANSACTION_WITHDRAWALAMOUNT_DESCRIPTION = "null/0-15桁 半角数字";

	/** depositAmount */
	public static final String API_PARAM_TRANSACTION_DEPOSITAMOUNT = "depositAmount";

	public static final String API_PARAM_TRANSACTION_DEPOSITAMOUNT_VALUE = "入金金額";

	public static final String API_PARAM_TRANSACTION_DEPOSITAMOUNT_EXAMPLE = "380000";

	public static final String API_PARAM_TRANSACTION_DEPOSITAMOUNT_DESCRIPTION = "null/0-15桁 半角数字";

	/** balance */
	public static final String API_PARAM_TRANSACTION_BALANCE = "balance";

	public static final String API_PARAM_TRANSACTION_BALANCE_VALUE = "取引後残高";

	public static final String API_PARAM_TRANSACTION_BALANCE_EXAMPLE = "740000";

	public static final String API_PARAM_TRANSACTION_BALANCE_DESCRIPTION = "1-17桁 半角数字";

	/** description */
	public static final String API_PARAM_TRANSACTION_DESCRIPTION = "description";

	public static final String API_PARAM_TRANSACTION_DESCRIPTION_VALUE = "入払摘要";

	public static final String API_PARAM_TRANSACTION_DESCRIPTION_EXAMPLE = "振込";

	public static final String API_PARAM_TRANSACTION_DESCRIPTION_DESCRIPTION = "null/0-5桁 全角すべて";

	/** description kana */
	public static final String API_PARAM_TRANSACTION_DESCRIPTIONKANA = "descriptionKana";

	public static final String API_PARAM_TRANSACTION_DESCRIPTIONKANA_VALUE = "入払摘要";

	public static final String API_PARAM_TRANSACTION_DESCRIPTIONKANA_EXAMPLE = "ハコザキタロウ";

	public static final String API_PARAM_TRANSACTION_DESCRIPTIONKANA_DESCRIPTION = "null/0-15桁 全角カナ";

	/** transactionId */
	public static final String API_PARAM_TRANSACTION_TRANSACTIONDESIGNATEDDATE = "transactionDesignatedDate";

	public static final String API_PARAM_TRANSACTION_TRANSACTIONDESIGNATEDDATE_VALUE = "取引日指定日";

	public static final String API_PARAM_TRANSACTION_TRANSACTIONDESIGNATEDDATE_EXAMPLE = "2017-06-18";

	public static final String API_PARAM_TRANSACTION_TRANSACTIONDESIGNATEDDATE_DESCRIPTION = "10桁 yyyy-MM-dd";

	/** fromDate */
	public static final String API_PARAM_TRANSACTION_FROMDATE = "fromDate";

	public static final String API_PARAM_TRANSACTION_FROMDATE_VALUE = "入出金明細照会の範囲(from)";

	public static final String API_PARAM_TRANSACTION_FROMDATE_DESCRIPTION = "yyyy-MM-dd";

	/** toDate */
	public static final String API_PARAM_TRANSACTION_TODATE = "toDate";

	public static final String API_PARAM_TRANSACTION_TODATE_VALUE = "入出金明細照会の範囲(to)";

	public static final String API_PARAM_TRANSACTION_TODATE_DESCRIPTION = "yyyy-MM-dd";

	/** index */
	public static final String API_PARAM_TRANSACTION_INDEX = "nextTransactionParam";

	public static final String API_PARAM_TRANSACTION_INDEX_VALUE = "次明細取得パラメータ";

	public static final String API_PARAM_TRANSACTION_INDEX_EXAMPLE = "002120161020000111";

	public static final String API_PARAM_TRANSACTION_INDEX_DESCRIPTION = "18桁 半角数字";

	public static final int API_PARAM_TRANSACTION_INDEX_LEN = 18;

	/** hasNext */
	public static final String API_PARAM_TRANSACTION_HASNEXT = "hasNext";

	public static final String API_PARAM_TRANSACTION_HASNEXT_VALUE = "未取得の入金明細有無";

	public static final String API_PARAM_TRANSACTION_HASNEXT_EXAMPLE = "true";

	/** transactionsList */
	public static final String API_PARAM_TRANSACTION_TRANSACTIONLIST = "transactionsList";

	public static final String API_PARAM_TRANSACTION_TRANSACTIONLIST_VALUE = "入金明細一覧";

	/** memo updatedDateTime */
	public static final String API_PARAM_MEMO_FROMUPDATEDDATETIME = "updatedDateTime";

	public static final String API_PARAM_MEMO_FROMUPDATEDDATETIME_VALUE = "メモ照会の範囲　最終照会日時";

	public static final String API_PARAM_MEMO_FROMUPDATEDDATETIME_DESCRIPTION = "25桁 yyyy-MM-dd'T'HH:mm:ssXXX";

	/** transactionId */
	public static final String API_PARAM_REV = "rev";

	public static final String API_PARAM_REV_VALUE = "リビジョンID";

	public static final String API_PARAM_REV_EXAMPLE = "fdsa1r3efds319fhiqfndsfwe";

	public static final String API_PARAM_REV_PATTERN = REGEXP_DIGIT_ALP_HALF;

	public static final String API_PARAM_REV_DESCRIPTION = "64桁 半角英数字";

	public static final int API_PARAM_REV_LEN = 64;

	/** account registedAt */
	public static final String API_PARAM_ACCOUNTREGISTEREDAT_VALUE = "口座登録日時";

	public static final String API_PARAM_ACCOUNTREGISTEREDAT_EXAMPLE = "2017-07-01T15:21:03+09:00";

	public static final String API_PARAM_ACCOUNTREGISTEREDAT_DESCRIPTION = "25桁 yyyy-MM-dd'T'HH:mm:ssXXX";

	/** feedback */
	public static final String API_PARAM_FEEDBACK = "feedback";

	public static final String API_PARAM_FEEDBACK_VALUE = "フィードバック";

	public static final String API_PARAM_FEEDBACK_EXAMPLE = "入出金明細が見やすくて良い！";

	public static final String API_PARAM_FEEDBACK_DESCRIPTION = "1-1000桁";

	public static final int API_PARAM_FEEDBACK_LEN_MIN = 1;

	public static final int API_PARAM_FEEDBACK_LEN_MAX = 1000;

	/** email */
	public static final String API_PARAM_EMAIL = "email";

	public static final String API_PARAM_EMAIL_VALUE = "メールアドレス";

	public static final String API_PARAM_EMAIL_EXAMPLE = "sample@sample.com";

	public static final String API_PARAM_EMAIL_DESCRIPTION = "Emailフォーマット 最大256文字（bytes）";

	public static final int API_PARAM_EMAIL_LEN_MAX = 256;

	/** WCAMobileUserId */
	public static final String API_PARAM_WCAMOBILEUSERID = "wcaMobileUserId";

	public static final String API_PARAM_WCAMOBILEUSERID_VALUE = "WCA MobileUserId";

	public static final String API_PARAM_WCAMOBILEUSERID_EXAMPLE = "vK8QIQjIrbTxjf02";

	public static final String API_PARAM_WCAMOBILEUSERID_DESCRIPTION = "半角英数字 100文字";

	public static final int API_PARAM_WCAMOBILEUSERID_LEN_MAX = 100;

	/** isValidation */
	public static final String API_PARAM_ISVALIDATION = "isValidationMode";

	public static final String API_PARAM_ISVALIDATION_VALUE = "有効性検証フラグ";

	public static final String API_PARAM_ISVALIDATION_EXAMPLE = "false";

	public static final String API_PARAM_ISVALIDATION_DESCRIPTION = "有効性検証のみの場合 true指定";

	/** Information */
	public static final String API_PARAM_INFORMATION_VALUE = "アプリケーション情報";

	/** applicationStatus */
	public static final String API_PARAM_APPLICATIONSTATUS_VALUE = "アプリケーションステータス";

	public static final String API_PARAM_APPLICATIONSTATUS_EXAMPLE = "UPDATE_RECOMMENDED";

	public static final String API_PARAM_APPLICATIONSTATUS_DESCRIPTION = "0:正常, 1:アップデート有";

	/** PushNotification1 */
	public static final String API_PARAM_PUSHNOTIFICATION1 = "PushNotification1";

	public static final String API_PARAM_PUSHNOTIFICATION1_VALUE = "Email通知設定1";

	public static final String API_PARAM_PUSHNOTIFICATION1_EXAMPLE = "true";

	/** PushNotification2 */
	public static final String API_PARAM_PUSHNOTIFICATION2 = "PushNotification2";

	public static final String API_PARAM_PUSHNOTIFICATION2_VALUE = "Email通知設定2";

	public static final String API_PARAM_PUSHNOTIFICATION2_EXAMPLE = "true";

	/** PushNotification3 */
	public static final String API_PARAM_PUSHNOTIFICATION3 = "PushNotification3";

	public static final String API_PARAM_PUSHNOTIFICATION3_VALUE = "Email通知設定3";

	public static final String API_PARAM_PUSHNOTIFICATION3_EXAMPLE = "true";

	/** EmailNotification1 */
	public static final String API_PARAM_EMAILNOTIFICATION1 = "emailNotification1";

	public static final String API_PARAM_EMAILNOTIFICATION1_VALUE = "Email通知設定1";

	public static final String API_PARAM_EMAILNOTIFICATION1_EXAMPLE = "false";

	/** EmailNotification2 */
	public static final String API_PARAM_EMAILNOTIFICATION2 = "emailNotification2";

	public static final String API_PARAM_EMAILNOTIFICATION2_VALUE = "Email通知設定2";

	public static final String API_PARAM_EMAILNOTIFICATION2_EXAMPLE = "false";

	/** EmailNotification3 */
	public static final String API_PARAM_EMAILNOTIFICATION3 = "emailNotification3";

	public static final String API_PARAM_EMAILNOTIFICATION3_VALUE = "Email通知設定3";

	public static final String API_PARAM_EMAILNOTIFICATION3_EXAMPLE = "false";

	/** appStoreRedirectUrl */
	public static final String API_PARAM_APPSTOREREDIRECTURL_VALUE = "メッセージ";

	public static final String API_PARAM_APPSTOREREDIRECTURL_EXAMPLE = "https://itunes.apple.com/de/app/dawawas/id00000000";

	// *****Cycle3*****
	/** UnreadCount */
	public static final String API_PARAM_UNREADCOUNT = "UnreadCount";

	public static final String API_PARAM_UNREADCOUNT_VALUE = "未読件数";

	public static final String API_PARAM_UNREADCOUNT_EXAMPLE = "5";

	public static final String API_PARAM_UNREADCOUNT_DESCRIPTION = "8桁 半角数字";
	// *****Cycle3*****
	
	
	// API Path
	public static final String API_API_PATH = "/api";

	public static final String API_APIV1_PATH = API_API_PATH + "/v1";

	public static final String API_OAUTH2_PATH = API_APIV1_PATH + "/oauth2";

	public static final String API_AUTH_PATH = API_APIV1_PATH + "/auth";

	public static final String API_RETAIL_ACCOUNTS_PATH = API_APIV1_PATH + "/retail/accounts";

	public static final String API_USER_PATH = API_APIV1_PATH + "/user";

	// API Operations
	public static final String API_OAUTH2_OPE_REDIRECTION_VALUE = "個人バンキングAPI OAuth2.0 認証URL取得（002001）";

	public static final String API_OAUTH2_OPE_REDIRECTION_NOTES = "個人バンキングAPI OAuth2.0 認証URLを取得する。";

	public static final String API_OAUTH2_OPE_REDIRECTION_PATH = "/banking/retail/" + API_PARAM_AUTHENTICATION;

	public static final String API_OAUTH2_OPE_REDIRECT_VALUE = "個人バンキングAPI OAuth2.0 リダイレクトエンドポイント（002002）";

	public static final String API_OAUTH2_OPE_REDIRECT_NOTES = "個人バンキングAPI OAuth2.0 リダイレクトエンドポイント。";

	public static final String API_OAUTH2_OPE_REDIRECT_PATH = "/banking/retail/" + API_PARAM_REDIRECTIONURL;

    public static final String API_OAUTH2_OPE_CALLBACK_VALUE = "個人バンキングAPI OAuth2.0 コールバック処理。OAuthトークン取得（002003）";

    public static final String API_OAUTH2_OPE_CALLBACK_NOTES = "個人バンキングAPI OAuth2.0 コールバック処理。OAuthトークンを取得する。";

    public static final String API_OAUTH2_OPE_CALLBACK_PATH = "/banking/retail/callback";

	/** bff accessToken */
	public static final String API_AUTH_OPE_ACCESSTOKEN_VALUE = "BFFアクセス・トークン取得（001001）";

	public static final String API_AUTH_OPE_ACCESSTOKEN_NOTES = "Mobile PassbookのBFFアクセス・トークンを取得する。</br>" + "</br>"
			+ "以下の項目をセットして、Basic認証を実施してください。</br>" + "「" + API_PARAM_PBK_AUTHORIZATION_HEADER_NAME + "」ヘッダーに「"
			+ API_PARAM_PBK_AUTHORIZATION_HEADER_DESCRIPTION + "」をセットする。</br>" + API_PARAM_REG_TYPE_VALUE + ":"
			+ API_PARAM_REG_TYPE_DESCRIPTION + "(UTF-8 URLEncode)</br>" + API_PARAM_DEVICE_ID_VALUE + ":"
			+ API_PARAM_DEVICE_ID_DESCRIPTION + "(UTF-8 URLEncode)</br>" + API_PARAM_OS_VALUE + ":"
			+ API_PARAM_OS_DESCRIPTION + "(UTF-8 URLEncode)</br>" + API_PARAM_OSVERSION_VALUE + ":"
			+ API_PARAM_OSVERSION_DESCRIPTION + "(UTF-8 URLEncode)</br>" + API_PARAM_APPVERSION_VALUE + ":"
			+ API_PARAM_APPVERSION_DESCRIPTION + "(UTF-8 URLEncode)</br>" + API_PARAM_DEVICE_NAME_VALUE + ":"
			+ API_PARAM_DEVICE_DESCRIPTION + "(UTF-8 URLEncode)</br>" + API_PARAM_APPSECRET_VALUE + ":"
			+ API_PARAM_APPSECRET_LEN_DESCRIPTIOIN + "</br>";

	public static final String API_AUTH_OPE_REFRESHTOKEN_PATH = "/" + API_PARAM_TOKEN;

	/** bff getAccount */
	public static final String API_RETAIL_ACCOUNTS_OPE_GETACCOUNT_VALUE = "口座照会（003001）";

	public static final String API_RETAIL_ACCOUNTS_OPE_GETACCOUNT_NOTES = "口座情報を照会する。";

	public static final String API_RETAIL_ACCOUNTS_OPE_GETACCOUNT_PATH = "/{" + API_PARAM_ACCOUNTTOKEN + "}";

	public static final String API_RETAIL_ACCOUNTS_OPE_GETTRANSACTIONS_VALUE = "入出金明細照会（003002）";

	public static final String API_RETAIL_ACCOUNTS_OPE_GETTRANSACTIONS_NOTES = "入出金明細照会する。";

	public static final String API_RETAIL_ACCOUNTS_OPE_GETTRANSACTIONS_PATH = "/{" + API_PARAM_ACCOUNTTOKEN + "}/"
			+ API_PARAM_TRANSACTIONS;

	public static final String API_RETAIL_ACCOUNTS_OPE_GETTRANSACTIONMEMO_VALUE = "入出金明細メモ取得（003005）";

	public static final String API_RETAIL_ACCOUNTS_OPE_GETTRANSACTIONMEMO_NOTES = "入出金明細のメモを取得する。";

	public static final String API_RETAIL_ACCOUNTS_OPE_GETTRANSACTIONMEMO_PATH = "/{" + API_PARAM_ACCOUNTTOKEN + "}/"
			+ API_PARAM_TRANSACTIONS + "/{" + API_PARAM_TRANSACTION_TRANSACTIONDATE + "}" + "/{"
			+ API_PARAM_TRANSACTIONID + "}/" + API_PARAM_MEMO;

	public static final String API_RETAIL_ACCOUNTS_OPE_ADDTRANSACTIONMEMO_VALUE = "入出金明細メモ追加（003006）";

	public static final String API_RETAIL_ACCOUNTS_OPE_ADDTRANSACTIONMEMO_NOTES = "入出金明細のメモを追加する。";

	public static final String API_RETAIL_ACCOUNTS_OPE_ADDTRANSACTIONMEMO_PATH = "/{" + API_PARAM_ACCOUNTTOKEN + "}/"
			+ API_PARAM_TRANSACTIONS + "/{" + API_PARAM_TRANSACTION_TRANSACTIONDATE + "}" + "/{"
			+ API_PARAM_TRANSACTIONID + "}/" + API_PARAM_MEMO;

	public static final String API_RETAIL_ACCOUNTS_OPE_DELETETRANSACTIONMEMO_VALUE = "入出金明細メモ削除（003004）";

	public static final String API_RETAIL_ACCOUNTS_OPE_DELETETRANSACTIONMEMO_NOTES = "入出金明細のメモを削除する。";

	public static final String API_RETAIL_ACCOUNTS_OPE_DELETETRANSACTIONMEMO_PATH = "/{" + API_PARAM_ACCOUNTTOKEN + "}/"
			+ API_PARAM_TRANSACTIONS + "/{" + API_PARAM_TRANSACTION_TRANSACTIONDATE + "}" + "/{"
			+ API_PARAM_TRANSACTIONID + "}/" + API_PARAM_MEMO;

	public static final String API_RETAIL_ACCOUNTS_OPE_UPDATETRANSACTIONMEMO_VALUE = "入出金明細メモ更新（003007）";

	public static final String API_RETAIL_ACCOUNTS_OPE_UPDATETRANSACTIONMEMO_NOTES = "入出金明細のメモを更新する。";

	public static final String API_RETAIL_ACCOUNTS_OPE_UPDATETRANSACTIONMEMO_PATH = "/{" + API_PARAM_ACCOUNTTOKEN + "}/"
			+ API_PARAM_TRANSACTIONS + "/{" + API_PARAM_TRANSACTION_TRANSACTIONDATE + "}" + "/{"
			+ API_PARAM_TRANSACTIONID + "}/" + API_PARAM_MEMO;

	public static final String API_USR_OPE_GETACCOUNTS_VALUE = "登録口座取得（004001）";

	public static final String API_USR_OPE_GETACCOUNTS_NOTES = "登録口座を取得する。";

	public static final String API_USR_OPE_GETACCOUNTS_PATH = "/" + API_PARAM_ACCOUNTS;

	public static final String API_USR_OPE_DELETEACCOUNT_VALUE = "登録口座削除（004002）";

	public static final String API_USR_OPE_DELETEACCOUNT_NOTES = "登録口座を削除する。";

	public static final String API_USR_OPE_DELETEACCOUNT_PATH = "/" + API_PARAM_ACCOUNTS + "/{" + API_PARAM_ACCOUNTTOKEN
			+ "}";

	// 登録口座メモ取得
	public static final String API_USR_OPE_GETACCOUNTMEMOS_VALUE = "入出金明細メモ照会（003003）";

	public static final String API_USR_OPE_GETACCOUNTMEMOS_NOTES = "入出金明細のメモを照会する。</br>"
			+ "照会方法は以下の2つのうちいづれかを指定可能。</br>" + "</br>" + "1. 最終照会日時照会範囲日付 *最終照会日時よりも未来に更新されたメモを取得</br> "
			+ CommonConst.API_PARAM_UPDATEDAT_EXAMPLE + " = 最終照会日時</br>" + "</br>" + "2. 最終照会日時照会範囲日付 + 次メモ取得パラメータ</br>"
			+ CommonConst.API_PARAM_NEXTMEMOPARAM + " = 前回の照会で取得した「次メモ取得パラメータ」</br>";

	public static final String API_USR_OPE_GETACCOUNTMEMOS_PATH = "/{" + API_PARAM_ACCOUNTTOKEN + "}/"
			+ API_PARAM_TRANSACTIONS + "/" + API_PARAM_MEMOS;

	// フィードバック追加
	public static final String API_USR_OPE_ADDFEEDBACK_VALUE = "フィードバック登録（004006）";

	public static final String API_USR_OPE_ADDFEEDBACK_NOTES = "フィードバックを登録する。";

	public static final String API_USR_OPE_ADDFEEDBACK_PATH = "/feedbacks";

	// コンタクト追加
	public static final String API_USR_OPE_UPDATEECONTACT_VALUE = "コンタクト変更（004005）";

	public static final String API_USR_OPE_UPDATECONTACT_NOTES = "ユーザのコンタクト情報を変更する。指定した項目のみ更新がされ、指定しない場合(null or 空文字)の場合は既存のレコード値の状態を維持する。";

	public static final String API_USR_OPE_UPDATECONTACT_PATH = "/contact";

	// コンタクト追加
	public static final String API_USR_OPE_GETCONTACT_VALUE = "コンタクト取得（004004）";

	public static final String API_USR_OPE_GETCONTACT_NOTES = "ユーザのコンタクト情報を取得する。";

	public static final String API_USR_OPE_GETCONTACT_PATH = "/contact";

	// コンタクト削除
	public static final String API_USR_OPE_DELETECONTACT_VALUE = "コンタクト削除（004003）";

	public static final String API_USR_OPE_DELETECONTACT_NOTES = "ユーザのコンタクト情報を削除する。";

	public static final String API_USR_OPE_DELETECONTACT_PATH = "/contact";

	// 通知設定取得
	public static final String API_USR_OPE_GETNOTIFICATION_SETTINGS_VALUE = "通知設定取得（004007）";

	public static final String API_USR_OPE_GETNOTIFICATION_SETTINGS_NOTES = "通知設定を取得する。　</br> Notification1:残高変更通知, Notification2:引落予定通知, Notification3:引落不能通知, NotificationWCA:汎用通知 ";

	public static final String API_USR_OPE_GETNOTIFICATION_SETTINGS_PATH = "/notification/settings";

	// 通知設定変更
	public static final String API_USR_OPE_UPDATENOTIFICATION_SETTINGS_VALUE = "通知設定変更（004008）";

	public static final String API_USR_OPE_UPDATENOTIFICATION_SETTINGS_NOTES = "通知設定を変更する。指定した項目のみ更新がされ、指定しない場合(null or 空文字)の場合は既存のレコード値の状態を維持する。　</br> Notification1:残高変更通知, Notification2:引落予定通知, Notification3:引落不能通知, NotificationWCA:汎用通知 ";

	public static final String API_USR_OPE_UPDATENOTIFICATION_SETTINGS_PATH = "/notification/settings";

	// *****Cycle3*****
	// 未読件数変更	
	public static final String API_USR_OPE_INBOX_UNREADCOUNT_VALUE = "未読件数変更(004009)";
		
	public static final String API_USR_OPE_INBOX_UNREADCOUNT_NOTES = "お知らせ未読件数を変更する。";
		
	public static final String API_USR_OPE_INBOX_UNREADCOUNT_PATH = "/inbox/unreadCount";
	// *****Cycle3*****	

	/** appStoreRedirectUrl */
	public static final String API_APPSTOREREDIRECTURL = "appStoreRedirectUrl";
	/** appStoreRedirectUrl */
	public static final String API_GOOGLEPLAYREDIRECTURL = "googlePlayRedirectUrl";
}
