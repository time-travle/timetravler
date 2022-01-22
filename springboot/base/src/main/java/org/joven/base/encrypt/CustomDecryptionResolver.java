/**
 * Project Name: blog project
 * File Name: CustomDecryptionResolver
 * Package Name: org.joven.base.encrypt
 * Date: 2020/1/31 11:57
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.base.encrypt;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import org.joven.base.utils.AESCBCPKCS5Padding;

/**
 * CreateBy Notebook
 * Date: 2020/1/31 11:57
 * Version:
 * Remark:
 */
public class CustomDecryptionResolver implements EncryptablePropertyResolver {
    /**
     * 前缀 必有的
     */
    private String prefix = "";
    /**
     * 后缀 可以没有
     */
    private String suffix = "";
    /**
     * 解密密钥若是加密了就是比有的，若是没有加密这可以没有
     */
    private String decry_key = "";

    public CustomDecryptionResolver(String prefixString, String decry_key) {
        this.prefix = prefixString;
        this.decry_key = decry_key;
    }

    public CustomDecryptionResolver(String prefixString, String suffix, String decry_key) {
        this.prefix = prefixString;
        this.decry_key = decry_key;
        this.suffix = suffix;
    }

    @Override
    public String resolvePropertyValue(String source) {
        String resString = source;
        if (null != source && source.startsWith(prefix)) {
            try {
                resString =
                        AESCBCPKCS5Padding.decrypt(getOriginalValue(source), decry_key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resString;
    }

    private String getOriginalValue(String source) {
        String origionValue = source;
        if ("".equals(suffix)) {
            // 没有后缀时
            System.out.println("CustomDecryptionResolver NO suffix");
            origionValue = source.substring(prefix.length());
        } else {
            // 有后缀时
            System.out.println("CustomDecryptionResolver Have suffix");
            int pre = source.indexOf(prefix);
            int suf = source.indexOf(suffix);
            origionValue = source.substring(pre, suf).substring(prefix.length());
        }
        return origionValue;
    }
}
