/**
 * Project Name: blog project
 * File Name: ValidateUtils
 * Package Name: org.joven.base.common
 * Date: 2019/11/8 22:38
 * Copyright (c) 2019,All Rights Reserved.
 */
package org.joven.base.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * CreateBy Administrator
 * Date: 2019/11/8 22:38
 * Version:
 * Remark:
 */
public class ValidateUtil {
    private ValidateUtil() {
    }

    /**
     * string 为null/""/或者只有空格都是空
     */
    public static boolean isEmptyString(String string) {
        // string is "" or null
        if ("".equals(string) || null == string) {
            return true;
        }
        // string is combine all with blank
        if (string.trim().length() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * list判断是不是空的集合
     *
     * @param list
     * @return
     */
    public static boolean isEmptyCollection(List<?> list) {
        // the list is null or undefined
        if (null == list || list.isEmpty() || 0 == list.size()) {
            return true;
        }
        return false;
    }

    /**
     * certainty - 这一措施的调用者能容忍的不确定性：如果调用返回true，
     * 则此BigInteger是素数超过概率(1 - 1/2确定性)。此方法的执行时间正比于该参数的值//原文出自【易百教程】，
     * 商业转载请联系作者获得授权，
     *
     * @param integer
     * @return
     */
    public static boolean isPrimeNum1(BigInteger integer) {
        return integer.isProbablePrime(1);
    }

    /**
     * 假如n是合数，必然存在非1的两个约数p1和p2，其中p1<=sqrt(n)，p2>=sqrt(n)
     *
     * @param num
     * @return
     */
    public static boolean isPrimeNum2(int num) {
        if (num <= 3) {
            return num > 1;
        }
        int s = (int) Math.sqrt(num);
        for (int i = 2; i <= s; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 质数还有一个特点，就是它总是等于 6x-1 或者 6x+1，其中 x 是大于等于1的自然数。
     * 如何论证这个结论呢，其实不难。首先 6x 肯定不是质数，因为它能被 6 整除；其次 6x+2 肯定也不是质数，
     * 因为它还能被2整除；依次类推，6x+3 肯定能被 3 整除；6x+4 肯定能被 2 整除。
     * 那么，就只有 6x+1 和 6x+5 (即等同于6x-1) 可能是质数了。
     * 所以循环的步长可以设为 6，然后每次只判断 6 两侧的数即可。
     * <p>
     * 质数等于 总是等于 6x-1 或者 6x+1
     * 等于 6x-1 或者 6x+1 的不一定是质数
     *
     * @param num 入场
     * @return 判断结果
     */
    public static boolean isPrimeNum3(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        // 在6的倍数两侧的不一定是质数，如35
        int s = (int) Math.sqrt(num);
        for (int i = 5; i <= s; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Object  判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty
     *
     * @param
     * @return
     */
    public static boolean isNullOrEmptyObject(Object obj) {
        if (obj == null)
            return true;

        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;

        if (obj instanceof Collection)
            return ((Collection<?>) obj).isEmpty();

        if (obj instanceof Map)
            return ((Map<?, ?>) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isNullOrEmptyObject(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    public static boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim())) {
            return s.matches("^[0-9]*$");
        } else {
            return false;
        }
    }

    public static boolean isNumeric2(String s) {
        return StringUtils.isNumeric(s);
    }
}
