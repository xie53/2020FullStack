package com.ibm.business.bean.req;

import static com.ibm.business.validator.InputTypeEnum.HALF_DIGIT;
import static com.ibm.business.validator.InputTypeEnum.MAIL;

import java.util.ArrayList;
import java.util.List;

import com.ibm.business.bean.res.AccountInfoRes;
import com.ibm.business.validator.InputConstraint;

public class AddressPhonenumberReq {

    /** 漢字氏名 */
	private String userKanjiName;
    /** カナ氏名 */
	private String userName;
    /** メールアドレス */
    @InputConstraint(itemName="メールアドレス", notEmpty=true, type=MAIL, minLength=1, maxLength=256)
	private String mailAddress;
    /** 通番 */
    @InputConstraint(itemName="通番", notEmpty=true, type=HALF_DIGIT)
	private String seqNo;
    /** ワンタイムパスワード */
    @InputConstraint(itemName="ワンタイムパスワード", notEmpty=true, type=HALF_DIGIT, length=6)
	private String oneTimePassword;
    /** 変更前住所 */
	private List<BeforeAddressReq> beforeAddress = new ArrayList<>();
    /** 変更後住所 */
	private List<AlteredAddressReq> alteredAddress = new ArrayList<>();
    /** 変更前電話番号 */
	private List<BeforePhoneNumberReq> beforePhoneNumber = new ArrayList<>();
    /** 変更後電話番号 */
	private List<AlteredPhoneNumberReq> alteredPhoneNumber = new ArrayList<>();
    /** 変更対象口座情報 */
	private List<AccountInfoRes> accountInfo = new ArrayList<>();

	public String getUserKanjiName() {
		return userKanjiName;
	}

	public void setUserKanjiName(String userKanjiName) {
		this.userKanjiName = userKanjiName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getOneTimePassword() {
		return oneTimePassword;
	}

	public void setOneTimePassword(String oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}

	public List<BeforeAddressReq> getBeforeAddress() {
		return beforeAddress;
	}

	public void setBeforeAddress(List<BeforeAddressReq> beforeAddress) {
		this.beforeAddress = beforeAddress;
	}

	public List<AlteredAddressReq> getAlteredAddress() {
		return alteredAddress;
	}

	public void setAlteredAddress(List<AlteredAddressReq> alteredAddress) {
		this.alteredAddress = alteredAddress;
	}

	public List<BeforePhoneNumberReq> getBeforePhoneNumber() {
		return beforePhoneNumber;
	}

	public void setBeforePhoneNumber(List<BeforePhoneNumberReq> beforePhoneNumber) {
		this.beforePhoneNumber = beforePhoneNumber;
	}

	public List<AlteredPhoneNumberReq> getAlteredPhoneNumber() {
		return alteredPhoneNumber;
	}

	public void setAlteredPhoneNumber(List<AlteredPhoneNumberReq> alteredPhoneNumber) {
		this.alteredPhoneNumber = alteredPhoneNumber;
	}

	public List<AccountInfoRes> getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(List<AccountInfoRes> accountInfo) {
		this.accountInfo = accountInfo;
	}

	@Override
	public String toString() {
		return "AddressPhonenumberReq [userKanjiName=" + userKanjiName + ", userName=" + userName + ", mailAddress=" + mailAddress 
				+ ", seqNo=" + seqNo + ", oneTimePassword=" + oneTimePassword + ", beforeAddress=" + beforeAddress + ", alteredAddress=" + alteredAddress 
				+ ", beforePhoneNumber=" + beforePhoneNumber + ", alteredPhoneNumber=" + alteredPhoneNumber + ", accountInfo=" + accountInfo + "]";
	}
}
