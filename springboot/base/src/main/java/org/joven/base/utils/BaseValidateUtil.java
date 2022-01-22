/**
 * Project Name: blog project
 * File Name: BaseValidateUtil
 * Package Name: org.joven.base.utils
 * Date: 2019/11/6 0:26
 * Copyright (c) 2019,All Rights Reserved.
 */
package org.joven.base.utils;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * CreateBy Notebook
 * Date: 2019/11/6 0:26
 * Version:
 * Remark: 自定义校验类
 */
public final class BaseValidateUtil {

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static boolean isNumericByAscill(String str) {
        for (int i = str.length(); --i >= 0; ) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }
}
