/**
 * Project Name: blog project
 * File Name: CustomDecryptionDetector
 * Package Name: org.joven.base.encrypt
 * Date: 2020/1/31 11:56
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.base.encrypt;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;

/**
 * CreateBy Notebook
 * Date: 2020/1/31 11:56
 * Version:
 * Remark:
 */
public class CustomDecryptionDetector implements EncryptablePropertyDetector {
    private String prefix = "";
    private String suffix = "";

    public CustomDecryptionDetector(String prefixString) {
        this.prefix = prefixString;
    }

    public CustomDecryptionDetector(String prefixString, String suffixString) {
        this.prefix = prefixString;
        this.suffix = suffixString;
    }

    /**
     * 判断属性不是加密过的 前缀必有的，后缀可以没有
     *
     * @param s
     * @return
     */
    @Override
    public boolean isEncrypted(String s) {
        if (null != s && "".equals(s)) {
            return s.startsWith(prefix);
        }
        return false;
    }

    /**
     * 解密之前如何去掉前/后缀
     *
     * @param s
     * @return
     */
    @Override
    public String unwrapEncryptedValue(String s) {
        return getOriginalValue(s);
    }

    private String getOriginalValue(String source) {
        String origionValue = source;
        if ("".equals(suffix)) {
            // 没有后缀时
            System.out.println("CustomDecryptionDetector NO suffix");
            origionValue = source.substring(prefix.length());
        } else {
            // 有后缀时
            System.out.println("CustomDecryptionDetectorHave suffix");
            int pre = source.indexOf(prefix);
            int suf = source.indexOf(suffix);
            origionValue = source.substring(pre, suf).substring(prefix.length());
        }
        return origionValue;
    }
}
