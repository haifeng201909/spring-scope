package com.haifeng.spring.springscope.controller;

import com.haifeng.spring.springscope.services.BeanInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author haifeng
 * @date 2020-08-27 0:36
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BeanInstance beanInstance1;

    @Autowired
    private BeanInstance beanInstance2;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        System.out.println("SessionBean-1");
        beanInstance1.getSessionBean().printId();
        System.out.println("SessionBean-2");
        beanInstance2.getSessionBean().printId();
        System.out.println("RequestBean-1");
        beanInstance1.getRequestBean().printId();
        System.out.println("RequestBean-2");
        beanInstance2.getRequestBean().printId();
        return "login";
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String check(){

        return "";
    }

}
