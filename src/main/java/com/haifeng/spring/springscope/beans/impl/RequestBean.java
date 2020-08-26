package com.haifeng.spring.springscope.beans.impl;

import com.haifeng.spring.springscope.beans.IRequestBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author haifeng
 * @date 2020-08-27 0:27
 */
@Component
@Scope(value = "request")
public class RequestBean implements IRequestBean {

    private UUID uuid;

    public RequestBean() {
        uuid = UUID.randomUUID();
    }

    public void printId() {
        System.out.println("RequestBean:" + uuid);
    }
}
