package com.my.modules.backstagemanagement.sys.controller;

import com.my.common.base.BaseController;
import com.my.common.modules.shiro.SystemAuthorizingRealm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lenovo on 2017/8/24.
 */
@Controller
public class LoginController extends BaseController{

    @RequestMapping(value="login",method= RequestMethod.GET)
    public String login(){
        return "back-stage-management/login";
    }

    @RequestMapping(value="login",method= RequestMethod.POST)
    public String login(ModelMap model){
        //SystemAuthorizingRealm
        return "";
    }

}
