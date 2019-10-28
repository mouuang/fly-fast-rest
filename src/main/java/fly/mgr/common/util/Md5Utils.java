package fly.mgr.common.util;

import java.security.MessageDigest;

import org.apache.shiro.codec.Hex;

/**
 * MD5 加密工具类
 * @date 2019年9月1日
 */
public class Md5Utils {
	
	private final static char[] DIGITS_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	
	private Md5Utils() {
		
	}
	
	
	/**
	 * MD5加密
	 * @param originalStr      待加密字符串
	 * @return String
	 */
	public static String getMd5(final String originalStr) {
        try {
            byte[] btInput = originalStr.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = DIGITS_CHAR[byte0 >>> 4 & 0xf];
                str[k++] = DIGITS_CHAR[byte0 & 0xf];
            }
            return new String(str).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
	
	
	@SuppressWarnings("static-access")
	private static String md5Hex(final String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(str.getBytes());
			return new String(new Hex().encode(digest));
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
	/**
	 * MD5加盐加密
	 * @param originalStr          待加密字符串
	 * @return String
	 */
	public static String getSaltMD5(final String originalStr) {
		// 生成一个6位的随机数
		String salt = RandomUtils.generateNumber(16);
		
		String hex = md5Hex(originalStr + salt);
		char[] cs = new char[48];
		for (int i = 0; i < 48; i += 3) {
			cs[i] = hex.charAt(i / 3 * 2);
			char c = salt.charAt(i / 3);
			cs[i + 1] = c;
			cs[i + 2] = hex.charAt(i / 3 * 2 + 1);
		}
		return String.valueOf(cs).toLowerCase();
	}
	
	/**
	 * .比较原字符串与md5后的是否一致
	 * @param originalStr          原始字符串
	 * @param md5Str               加密后的字符串
	 * @return boolean
	 */
	public static boolean checkMd5(final String originalStr, final String md5Str) {
		return md5Str.equals(getMd5(originalStr));
	}
	
	
	/**
	 * .验证加盐后是否和原文一致
	 * @param originalStr          原字符串
	 * @param md5SaltStr           加盐加密后的字符串 
	 * @return boolean
	 */
	public static boolean checkSaltMD5(final String originalStr, final String md5SaltStr) {
		char[] cs1 = new char[32];
		char[] cs2 = new char[16];
		for (int i = 0; i < 48; i += 3) {
			cs1[i / 3 * 2] = md5SaltStr.charAt(i);
			cs1[i / 3 * 2 + 1] = md5SaltStr.charAt(i + 2);
			cs2[i / 3] = md5SaltStr.charAt(i + 1);
		}
		String salt = new String(cs2);
		return md5Hex(originalStr + salt).equals(String.valueOf(cs1));
	}
	
	
	public static void main(String[] args) {
        System.out.println(getSaltMD5("admin@2019"));
    }
	
}
