/**
 * Project Name: blog project
 * File Name: Base64SecretUtil
 * Package Name: org.joven.base.utils
 * Date: 2019/12/15 17:10
 * Copyright (c) 2019,All Rights Reserved.
 */
package org.joven.base.utils;

import java.util.Base64;

/**
 * CreateBy Notebook
 * Date: 2019/12/15 17:10
 * Version:
 * Remark: 使用Base64  进行 加解密
 * JDK中的/lib/tool.jar和/lib/rt.jar已经从Java SE 9中删除 使用包直接用 java.util.Base64下的加解密方法
 */
public class Base64SecretUtil {
    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptString(String key) throws Exception {
        return Base64.getDecoder().decode(key);
    }

    public static byte[] decryptBytes(byte[] key) throws Exception {
        return Base64.getDecoder().decode(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt2Byte(byte[] key) throws Exception {
        return Base64.getEncoder().encode(key);
    }

    public static String encrypt2String(byte[] key) throws Exception {
        return Base64.getEncoder().encodeToString(key);
    }
}
