/**
 * Project Name: blog project
 * File Name: MD5SecretUtil
 * Package Name: org.joven.base.utils
 * Date: 2019/12/15 17:26
 * Copyright (c) 2019,All Rights Reserved.
 */
package org.joven.base.utils;

import java.security.MessageDigest;

/**
 * CreateBy Notebook
 * Date: 2019/12/15 17:26
 * Version:
 * Remark:
 */
public class MD5OrSHASecretUtil {
    /**
     * MD5加密
     * key = MD5 or SHA
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance(key);
        md5.update(data);
        return md5.digest();
    }
}
