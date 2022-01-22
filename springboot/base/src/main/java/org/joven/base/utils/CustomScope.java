/**
 * Project Name: blog project
 * File Name: CustomScope
 * Package Name: org.joven.base.utils
 * Date: 2020/2/9 12:29
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.base.utils;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * CreateBy Notebook
 * Date: 2020/2/9 12:29
 * Version:
 * Remark:
 */
public class CustomScope implements Scope {
    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        return null;
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
