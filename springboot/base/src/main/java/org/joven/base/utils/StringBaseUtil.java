/**
 * Copyright © 2018 +
 * All Rights Reserved
 * Create on 2018年8月11日
 */
package org.joven.base.utils;

/**
 * @author Administrator
 * @date 2018年8月11日下午4:22:52
 * @Package_name org.joven.foundation.utils.common
 * @Project_name org.joven.foundation.utils
 * @Type_name 类名 StringUtil
 */
public class StringBaseUtil {
    private static String base = "amnopqrstbcdefghijkluvwxyzAMNOPQRSTBCDEFGHIJKLUVWXYZ1234567890";

    private StringBaseUtil() {
    }

    /**
     * 获取随机制定长度的字符串 字符的组成元素 a-zA-Z0-9
     *
     * @param length
     * @return
     */
    public static String getRondomString(int length) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            sb.append(base.charAt((int) Math.round(Math.random() * (62))));
        }
        String ss = sb.toString();
        return ss;
    }

    /**
     * String 转 ASCII
     *
     * @param value
     * @return
     */
    public static String stringToASCll(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     * BCD 转 String
     *
     * @param bytes
     * @return
     */
    public static String bcd2Str(byte[] bytes) {
        char temp[] = new char[bytes.length * 2], val;

        for (int i = 0; i < bytes.length; i++) {
            val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
            temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

            val = (char) (bytes[i] & 0x0f);
            temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }

    /**
     * ASCII 转 BCD
     *
     * @param ascii
     * @param asc_len
     * @return
     */
    public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
        byte[] bcd = new byte[asc_len / 2];
        int j = 0;
        for (int i = 0; i < (asc_len + 1) / 2; i++) {
            bcd[i] = asc_to_bcd(ascii[j++]);
            bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }

    /**
     * ASC 转 BCD
     *
     * @param asc
     * @return
     */
    public static byte asc_to_bcd(byte asc) {
        byte bcd;

        if ((asc >= '0') && (asc <= '9'))
            bcd = (byte) (asc - '0');
        else if ((asc >= 'A') && (asc <= 'F'))
            bcd = (byte) (asc - 'A' + 10);
        else if ((asc >= 'a') && (asc <= 'f'))
            bcd = (byte) (asc - 'a' + 10);
        else
            bcd = (byte) (asc - 48);
        return bcd;
    }
}
