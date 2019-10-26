package fly.mgr.common.util;

import java.security.Key;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * DES加密工具类
 * @date 2019年8月31日 
 */
public class DesUtils {
	
	/** 偏移变量，固定占8位字节 */
    private final static String IV_PARAMETER = "12345678";
    /** 密钥算法 */
    private static final String ALGORITHM = "DES";
    /** 加密/解密算法-工作模式-填充模式 */
    private static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";
    /** 默认编码 */
    private static final String CHARSET = "utf-8";
	
    
	private DesUtils() {	}
	

	/**  
	 * 生成key
	 * @param password
	 * @return String
	 * @throws Exception
	 */
    private static Key generateKey(String password) throws Exception {
        DESKeySpec dks = new DESKeySpec(password.getBytes(CHARSET));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(dks);
    }
    
    /**
     * DES加密
     * @param plainText     待加密字符串
     * @param key           密码(最短8位)
     * @return String       加密后的字符串
     * @throws Exception
     */
    public static String encrypt(String plainText, String key) throws Exception {
        if (key == null || key.length() < 8) {
            throw new RuntimeException("DES加密失败，key不能小于8位");
        }
        if (plainText == null) {
        	return null;
        }
        
        Key secretKey = generateKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] bytes = cipher.doFinal(plainText.getBytes(CHARSET));
 
        return new String(Base64.getEncoder().encode(bytes));
    }
    
    
    /**
     * DES解密
     * @param encryptText       待解密字符串
     * @param key               密码(最短8位)
     * @return String           解密后的字符串
     * @throws Exception
     */
    public static String decrypt(String encryptText, String key) throws Exception {
        if (key== null || key.length() < 8) {
            throw new RuntimeException("DES解密失败，key不能小于8位");
        }
        if (encryptText == null) {
        	return null;
        }
            
        Key secretKey = generateKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        
        Decoder decoder = Base64.getDecoder();
        return new String(cipher.doFinal(decoder.decode(encryptText.getBytes(CHARSET))), CHARSET);
    }
    
}
