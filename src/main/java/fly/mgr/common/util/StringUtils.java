package fly.mgr.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @date 2019年8月31日
 */
public class StringUtils {
    
	private static final String DIGITAL_REGEX = "^[0-9]+$";
	/** 用户名正则表达式 */
	private static final String USER_NAME_REGEX = "^[a-zA-Z0-9]{5,20}$";
	/** 手机号正则表达式 */
	private static final String PHONE_REGEX = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$";
	/** 邮箱正则表达式 **/
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
	/** 身份证省编码 **/
	private static final String[] ID_CARD_PROV_CODE = {"11", "12", "13", "14", "15", "21", 
	           "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42", 
	           "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", 
	           "63", "64", "65", "71", "81", "82", "91"};
	
	
	private StringUtils () { }
	
	/**
	 * 字符串是否为空
	 * @param input
	 * @return boolean
	 */
	public static boolean isBlank(final String input) {
		if (null == input) {
			return true;
		}
		
		String trimStr = input.replaceAll("\\s*", "");
		return trimStr.length() == 0 || "null".equals(trimStr.toLowerCase());
	}
	
	
	/**
	 * 字符串是否不为空
	 * @param: str 
	 * @return boolean
	 */
	public static boolean isNotBlank(final String input) {
		return !isBlank(input);
	}
	
	/**
	 * 是否是纯数字
	 * @param digital
	 * @return boolean
	 */
	public static boolean isDigital(String digital) {
	    Pattern p = Pattern.compile(DIGITAL_REGEX);
        Matcher m = p.matcher(digital);
        return m.matches();
	}
	
	
	/**
	 * 去空格
	 * @param obj 
	 * @return String 
	 */
	public static String trimSpace(final Object obj) {
		String objStr = String.valueOf(obj);
		String trimStr = objStr.replaceAll("\\s*", "");
		return "null".equals(trimStr.toLowerCase()) ? "" : trimStr;
	}
	
	
	/**
	 * 校验用户名是否合法
	 * @param userName
	 * @return boolean
	 */
	public static boolean checkUserName(String userName) {
        Pattern p = Pattern.compile(USER_NAME_REGEX);
        Matcher m = p.matcher(userName);
        return m.matches();
    }
	
	
	/**
	 * 是否是手机号
	 * @param phoneStr
	 * @return boolean
	 */
	public static boolean isMobile(String phoneNo) {
		Pattern p = Pattern.compile(PHONE_REGEX);
        Matcher m = p.matcher(phoneNo);
        return m.matches();
	}
	
	/**
	 * 是否是邮箱地址
	 * @param emailAddrss
	 * @return boolean
	 */
	public static boolean isEmail(String emailAddrss) {
		Pattern p = Pattern.compile(EMAIL_REGEX);
        Matcher m = p.matcher(emailAddrss);
        return m.matches();
	}
	
	/**
	 * 是否是身份证号
	 * @param idCardNo
	 * @return boolean
	 */
	public static boolean isIdCardNo(final String idCardNo) {
        if (idCardNo == null) {
             return false; 
        }
        // 非18位为假 
        if (idCardNo.length() != 18) { 
            return false; 
        } 
        // 前17位全部为数字
		if (!isDigital(idCardNo.substring(0, 17))) {
		    return false;
		}
		// 校验省编码
		if (!checkIdCardProvCode(idCardNo.substring(0, 2))) {
		    return false;
		}
		String birthday = idCardNo.substring(6, 14);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
            Date birthDate = sdf.parse(birthday);
            String tmpDate = sdf.format(birthDate);
            // 身份证日期错误 
            if (!tmpDate.equals(birthday)) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
		return true;
	}
	
	/**
	 * 校验省编码
	 * @param provCode
	 * @return boolean
	 */
	private static boolean checkIdCardProvCode(String provCode) {
	    for (String code : ID_CARD_PROV_CODE) {
	        if (code.equals(provCode)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	
	/**
	 * 填充0到指定长度
	 * @param
	 * @return String
	 * @throws
	 */
	public static String fillZeroToLength(final String target, final int length) {
	    if (target.length() >= length) {
	        return target.substring(0, length);
	    }
	    
	    StringBuffer sb = new StringBuffer(length);
	    while(sb.length() + target.length() < length) {
	        sb.append("0");
	    }
	    sb.append(target);
	    return sb.substring(0, length);
	}
	
}
