package com.example.demo.controller;

import com.example.demo.model.attendant;
import com.example.demo.model.member;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.server.endpoint.interceptor.DelegatingSmartEndpointInterceptor;

import javax.annotation.Resource;

@EnableAutoConfiguration
@Controller
public class loginController {
    @RequestMapping("/login")
    public static String login(ModelMap model){
        model.addAttribute("model","login");
        model.addAttribute("ismember",false);
        model.addAttribute("goway","/myquestions");
        return "login";
    }

    @RequestMapping("/Clogin")
    public static String Clogin(ModelMap model){
        model.addAttribute("model","Clogin");
        model.addAttribute("goway","/attendant");
        return "login";
    }

    @RequestMapping("/register")
    public static String register(ModelMap model){
        model.addAttribute("model","register");
        model.addAttribute("goway","/addmember");
        return "login";
    }

    @Resource
    private com.example.demo.service.memberService memberService;

    @RequestMapping("/addmember")
    public String addmember(@RequestParam(value = "tel") String tel, @RequestParam(value = "pwd") String pwd,
                            @RequestParam(value = "username") String username, @RequestParam(value = "email") String email, ModelMap model){
        Object test=this.memberService.getmemberBytel(tel);
        Object test2=this.memberService.getmemberByemail(email);
        if(test!=null || test2!=null){
            model.addAttribute("model","register");
            model.addAttribute("goway","/addmember");
            model.addAttribute("ismember",true);
            model.addAttribute("wrong","电话或邮箱已使用");
            return "login";
        }
        member member = new member();
        member.setTel(tel);
        member.setUsername(username);
        member.setPwd(pwd);
        member.setEmail(email);
        this.memberService.addmember(member);
        model.addAttribute("member",member);
        return "myquestions";
    }


}
