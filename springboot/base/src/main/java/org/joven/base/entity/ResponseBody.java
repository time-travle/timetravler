/**
 * Project Name: blog project
 * File Name: ResponseBody
 * Package Name: org.joven.base.entity
 * Date: 2019/11/5 22:29
 * Copyright (c) 2019,All Rights Reserved.
 */
package org.joven.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Remark: 前端请求后端时的一个返回值  使用注解的方式 省略set/get
 */
@Data
@AllArgsConstructor
public class ResponseBody<T> implements Serializable {
    private String returnCode;
    private String returnMessage;
    private T data;
    public ResponseBody() {
        this.returnCode = "0";
        this.returnMessage = "success";
    }
    public ResponseBody(String code,String message) {
        this.returnCode = code;
        this.returnMessage = message;
    }
}
