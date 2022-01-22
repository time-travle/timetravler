/**
 * Project Name: blog project
 * File Name: Common
 * Package Name: org.joven.common.common
 * Date: 2020/1/5 20:20
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.common;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 20:20
 * Version: 1.0
 * Remark: 工程下的工具常量类
 */
public final class CommonConstants {
    public interface ExtField {
        public static final String Ext1 = "ext1";
        public static final String Ext2 = "ext2";
        public static final String Ext3 = "ext3";
        public static final String Ext4 = "ext4";
        public static final String Ext5 = "ext5";
        public static final String Ext6 = "ext6";
        public static final String Ext7 = "ext7";
        public static final String Ext8 = "ext8";
        public static final String Ext9 = "ext9";
    }

    public interface CharsetType {
        public static final String GB_18030 = "GB18030";
        public static final String ISO8859_1 = "ISO8859-1";
    }

    /*
    用法：CommonConstants..Number.ONE.name() 区取得 ONE
    用法：CommonConstants..Number.ONE.toString() 区取得 ONE
     */
    public enum Number {
        ONE, TWO;
    }

    /*
    用法： CommonConstants.Status.FAIL.getText() 获取对应的text
    用法： CommonConstants.Status.FAIL.getIndex() 获取对应的index
     */
    public enum Status {
        SUCCEED(1, "success"), FAIL(2, "fail");

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        private int index;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        private String text;

        private Status(int index, String text) {
            this.index = index;
            this.text = text;
        }
    }

    /*
    季节
     */
    public enum Season {
        Spring("Spr", "Spring"),
        Summer("Sum", "Summer"),
        Autumn("Aut", "Autumn"),
        Winter("Win", "Winter");

        public void setShortCode(String shortCode) {
            this.shortCode = shortCode;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getShortCode() {
            return this.shortCode;
        }

        public String getValue() {
            return this.value;
        }

        private String shortCode;
        private String value;

        private Season(String shortCode, String value) {
            this.value = value;
            this.shortCode = shortCode;
        }
    }

    public enum Month {
        January("January", "Jan", 1),
        February("February", "Feb", 2),
        March("March", "Mar", 3),
        April("April", "Apr", 4),
        May("May", "May", 5),
        June("June", "Jun", 6),
        July("July", "Jul", 7),
        August("August", "Aug", 8),
        September("September", "Sep", 9),
        October("October", "Oct", 10),
        November("November", "Nov", 11),
        December("December", "Dec", 12);

        public void setShortCode(String shortCode) {
            this.shortCode = shortCode;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setSoft(int soft) {
            this.soft = soft;
        }

        public String getShortCode() {
            return this.shortCode;
        }

        public String getValue() {
            return this.value;
        }

        public int getSoft() {
            return this.soft;
        }

        private String shortCode;
        private String value;
        private int soft;

        private Month(String value, String shortCode, int soft) {
            setSoft(soft);
            setShortCode(shortCode);
            setValue(value);
        }
    }
}