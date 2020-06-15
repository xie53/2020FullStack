package com.ibm.business.buyer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
		
	private static final String[][] CONV_DATA = {
	        {
	            //英字
	            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
	            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
	            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
	            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
	            //数字
	            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
	            //記号
	            "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":",
	            ";", "<", "=", ">", "?", "@", "[", "\\", "]", "^", "_", "`", "{", "|", "}", "~",
	            //スペース
	            " ",
	            "¥"
	        },
	        {
	            //英字
	            "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ", "Ｍ", "Ｎ",
	            "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ", "Ｙ", "Ｚ",
	            "ａ", "ｂ", "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ",
	            "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ",
	            //数字
	            "１", "２", "３", "４", "５", "６", "７", "８", "９", "０",
	            //記号
	            "！", "”", "＃", "＄", "％", "＆", "’", "（", "）", "＊", "＋", "，", "ー", "．", "／", "：",
	            "；", "＜", "＝", "＞", "？", "＠", "［", "＼", "］", "＾", "＿", "｀", "｛", "｜", "｝", "～",
	            //スペース
	            "　",
	            "￥"
	        }
	    };
	
	public static boolean isEmpty(String... texts) {
		
		if(texts == null)
			return true;
		
		for(String text: texts){
			return text == null || "".equals(text);
		}
		return false;
	}

	public static boolean isLength(String text, int len) {
		
		if (isEmpty(text))
			return false;

		int length = text.length();
		boolean isLengthBetween = (length == len);

		return isLengthBetween;

	}
	
	public static boolean isLengthBetween(String text, int min, int max) {
		
		if (isEmpty(text))
			return false;

		int length = text.length();
		boolean isLengthBetween = ((min <= length) && (length <= max));

		return isLengthBetween;

	}

	public static boolean isLengthBetween(int num, int min, int max) {
		
		return isLengthBetween(String.valueOf(num), min, max);

	}

	public static boolean isPatternMatched(String text, String regex) {
		
		if (isEmpty(text) || isEmpty(regex))
			return false;

		boolean isPatternMatched = text.matches(regex);
		return isPatternMatched;

	}
	
    public static boolean checkEmail(String strEmail) {

        String allowChars = "[A-Za-z0-9\\!\"#\\$%&'\\(\\)\\*\\+\\,\\-\\.\\/\\:;<\\=>\\?\\[\\\\\\]\\^\\_`\\{\\|\\}~]+";
        String strPattern = "^" + allowChars + "@" + allowChars + "+$";
        Pattern p = Pattern.compile(strPattern);
        
        String strWork = exchangeMail(strEmail);
        
        Matcher m = p.matcher(strWork);
        return m.matches();
    }
	
    public static String exchangeMail(String strEmail) {

        String strWork = strEmail;

        //ダブルバイト → シングルバイト
        for (int i = 0; i < CONV_DATA[0].length; i++) {
            strWork = strWork.replace(CONV_DATA[1][i], CONV_DATA[0][i]);
        }
        
        //全角・半角スペース/改行削除
        strWork =  trim(strWork);

        strWork = strWork.replace("¥","\\");

        return strWork;
    }
    
    public static String trimWhitespace(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int st = 0;
        int len = str.length();
        char[] val = str.toCharArray();
        while ((st < len) && ((val[st] <= '\u0020') || (val[st] == '\u00A0') || (val[st] == '\u3000'))) {
            st++;
        }
        while ((st < len) && ((val[len - 1] <= '\u0020') || (val[len - 1] == '\u00A0') || (val[len - 1] == '\u3000'))) {
            len--;
        }
        return ((st > 0) || (len < str.length())) ? str.substring(st, len) : str;
    }
    
    public static String trim(String _str){
        // 空白削除
        String str = trimWhitespace(_str);
        str = str.replaceAll("\n", "").replaceAll("\r", "");
        return str;
    }
	
}
