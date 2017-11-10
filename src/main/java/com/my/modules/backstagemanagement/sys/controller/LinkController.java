package com.my.modules.backstagemanagement.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lenovo on 2017/11/7.
 */
@Controller
@RequestMapping("/back/link")
public class LinkController {

    @RequestMapping(value="login",method= RequestMethod.GET)
    public String login(){
        return "back-stage-management/login";
    }
}
