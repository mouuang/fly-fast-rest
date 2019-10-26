package fly.mgr.common.util;

import java.util.Random;

/**
 * 获取随机数工具类
 * @date 2019年9月1日
 */
public class RandomUtils {
    
	/** 数字 */
	private final static String NUMBER_CHAR = "0123456789"; 
	private final static int NUMBER_CHAR_LENGTH = NUMBER_CHAR.length();
	
	/** 字母 */
	private final static String LETTER_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static int LETTER_CHAR_LENGTH = LETTER_CHAR.length();
	
	/** 数字+字母 */
	private final static String ALL_CHAR = "012345678abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static int ALL_CHAR_LENGTH = ALL_CHAR.length();
	
	private RandomUtils () { }
	
	
	/**
	 * 获取指定长度的随机字符串(包含数字、大小写字母)
	 * @param length       长度
	 * @return String
	 */
	public static String generate(int length) {
		StringBuffer sb = new StringBuffer(length);
		Random random = new Random();
		for (int index = 0; index < length; index ++) {
			sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR_LENGTH)));
		}
		return sb.toString();
	}
	
	
	/**
	 * 获取指定长度的随机字母(只含字母)
	 * @param length       长度
	 * @return String
	 */
	public static String generateLetter(int length) {
		StringBuffer sb = new StringBuffer(length);
		Random random = new Random();
		for (int index = 0; index < length; index ++) {
			sb.append(LETTER_CHAR.charAt(random.nextInt(LETTER_CHAR_LENGTH)));
		}
		return sb.toString();
	}
	
	
	/**
	 * 获取指定长度的数字随机数(只含数字)
	 * @param length       长度
	 * @return String
	 */
	public static String generateNumber(int length) {
		StringBuffer sb = new StringBuffer(length);
		Random random = new Random();
		for (int index = 0; index < length; index ++) {
			sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR_LENGTH)));
		}
		return sb.toString();
	}
	
}
