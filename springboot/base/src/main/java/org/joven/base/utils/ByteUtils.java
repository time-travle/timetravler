package org.joven.base.utils;

import java.security.SecureRandom;
import java.util.Locale;

public class ByteUtils {
    /**
     * 获取指定位数的byte数组
     */
    public static byte[] getRandomBytes(int length) {
        byte[] randomBytes = new byte[length];
        SecureRandom random = new SecureRandom();
        random.nextBytes(randomBytes);
        return randomBytes;
    }

    public static byte[] hexStringToBytes(String hexString) {

        if (null == hexString || "".equals(hexString)) {
            return null;
        }
        hexString = hexString.toUpperCase(Locale.US);
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            result[i] = ((byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[(pos + 1)])));
        }
        return result;
    }

    public static String bytesTOHexString(byte[] src) {

        StringBuilder stringBuilder = new StringBuilder();
        if (null == src || "".equals(src)) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() <= 0) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    private static int charToByte(char c) {
        return (byte) "123456789ABCDEF".indexOf(c);
    }
}
