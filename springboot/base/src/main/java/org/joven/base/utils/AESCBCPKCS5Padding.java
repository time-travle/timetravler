package org.joven.base.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;

/**
 * AES/CBC/PKCS5Padding
 *
 * @author Notebook
 */
public class AESCBCPKCS5Padding {
    /**
     * 随机向量组大小
     */
    private static final int IV_BYTEES_LENGTH = 16;
    /**
     * 加密算法
     */
    private static final String CRYPT_MODE = "AES/CBC/PKCS5Padding";

    /**
     * 解密解码 密钥必须为 16 或者32位
     *
     * @param message
     * @param key
     * @return
     */
    public static String decrypt(String message, String key) throws Exception {
        if ("".equals(message) || null == message) {

            return null;
        }
        // 先使用Base64进行解码
        // byte[] encrypted =
        // com.sun.org.apache.xml.internal.security.utils.Base64.decode(message);
        byte[] encrypted = Base64Utils.decode(message.getBytes("UTF-8"));
        // 取得16位随机向量组
        byte[] iv = new byte[IV_BYTEES_LENGTH];
        System.arraycopy(encrypted, 0, iv, 0, IV_BYTEES_LENGTH);
        byte[] encryptedMsg = new byte[encrypted.length - IV_BYTEES_LENGTH];
        System.arraycopy(encrypted, IV_BYTEES_LENGTH, encryptedMsg, 0, encrypted.length - IV_BYTEES_LENGTH);

        byte[] resBytess = null;

        Cipher cipher = Cipher.getInstance(CRYPT_MODE);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"), new IvParameterSpec(iv));
        resBytess = cipher.doFinal(encryptedMsg);
        return new String(resBytess, "UTF-8");
    }

    /**
     * 加 密钥必须为 16 或者32位密
     *
     * @param message
     * @param key
     * @return
     */
    public static String encrypt(String message, String key) throws Exception {

        byte[] iv = ByteUtils.getRandomBytes(IV_BYTEES_LENGTH);

        Cipher cipher = Cipher.getInstance(CRYPT_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"), new IvParameterSpec(iv));

        byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));
        int encryptedLength = encrypted.length;
        byte[] encryptedwithIv = new byte[encryptedLength + IV_BYTEES_LENGTH];
        System.arraycopy(iv, 0, encryptedwithIv, 0, IV_BYTEES_LENGTH);
        System.arraycopy(encrypted, 0, encryptedwithIv, IV_BYTEES_LENGTH, encryptedLength);

        // String res =
        // com.sun.org.apache.xml.internal.security.utils.Base64.encode(encryptedwithIv);
        // return res;
        byte[] res = Base64Utils.encode(encryptedwithIv);
        return new String(res, "UTF-8");
    }
}
