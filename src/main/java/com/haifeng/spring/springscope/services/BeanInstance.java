package com.haifeng.spring.springscope.services;

import com.haifeng.spring.springscope.beans.IRequestBean;
import com.haifeng.spring.springscope.beans.ISessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author haifeng
 * @date 2020-08-27 0:34
 */
@Service
@Scope(value = "prototype")
public class BeanInstance {

    @Autowired
    private ISessionBean sessionBean;

    @Autowired
    private IRequestBean requestBean;

    public ISessionBean getSessionBean() {
        return sessionBean;
    }

    public IRequestBean getRequestBean() {
        return requestBean;
    }
}
