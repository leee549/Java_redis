package cn.lhx.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lee549
 * @date 2020/3/1 21:55
 */
@Controller
@RequestMapping("/shiro")
public class ShiroController {

    @RequiresAuthentication
    @RequestMapping("/test")
    public String test(){
        System.out.println("通过验证已经正常登录！");
        return "forward:/WEB-INF/success.jsp";
    }
    
    @RequiresUser
    @RequestMapping("/test2")
    public String test2(){
        System.out.println("已有身份通过验证，或记住我");
        return "forward:/WEB-INF/success.jsp";
    }

    @RequiresPermissions("employee:list")
    @RequestMapping("/test03")
    public String test3(){
        System.out.println("===");
        return "forward:/WEB-INF/success.jsp";
    }
}
