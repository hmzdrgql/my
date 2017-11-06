package com.my.modules.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2017/8/24.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value="/toBackStageManagement",method= RequestMethod.GET)
    public String toBackStageManagement(){
        return "back-stage-management/login";
    }

    @RequestMapping(value="/toScriptInstance",method= RequestMethod.GET)
    public String toScriptInstance(){
        return "script-instance/index";
    }

    @RequestMapping(value="/toPictureVerification",method= RequestMethod.GET)
    public String toPictureVerification(){
        return "script-instance/PictureVerification";
    }
}
