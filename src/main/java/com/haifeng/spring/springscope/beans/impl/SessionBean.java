package com.haifeng.spring.springscope.beans.impl;

import com.haifeng.spring.springscope.beans.ISessionBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author haifeng
 * @date 2020-08-27 0:30
 */
@Component
@Scope(value = "session")
public class SessionBean implements ISessionBean {

    private UUID uuid;

    public SessionBean() {
        uuid = UUID.randomUUID();
    }

    public void printId() {
        System.out.println("SessionBean:" + uuid);
    }
}
