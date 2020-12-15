package com.example.demo.controller;

import com.example.demo.model.member;
import com.example.demo.service.i_q_aService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@EnableAutoConfiguration
@Controller
@RequestMapping("/myquestions")
public class myquestionsController {
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private com.example.demo.service.memberService memberService;
    @Resource
    private com.example.demo.service.investService investService;
    @Resource
    private com.example.demo.service.i_q_aService i_q_aService;
    @Resource
    private com.example.demo.service.answerService answerService;
    @Resource
    private com.example.demo.service.questionService questionService;


    @RequestMapping(path = {"/",""})
    public  String index(@RequestParam(value="tel",required = false) String tel, @RequestParam(value="pwd",required = false) String pwd,HttpServletRequest request,ModelMap model){
        Object test=this.memberService.getmemberBytel(tel);
        HttpSession session=request.getSession();//获取session并将userName存入session对象
        if(test==null){
            model.addAttribute("model","login");
            model.addAttribute("ismember",true);
            model.addAttribute("wrong","账号未注册，请注册");
            model.addAttribute("goway","/myquestions");
            return "login";
        }
        member member = (member)test;
        if(member.getPwd().equals(pwd)){
            session.setAttribute("userName", member.getUsername());
            session.setAttribute("tel", member.getTel());
            model.addAttribute("member",member);
            model.addAttribute("opttype","main");
            stringRedisTemplate.opsForValue().set(tel, member.getUsername());
//            String string =stringRedisTemplate.opsForValue().get("aaa");
        }
        else {
            model.addAttribute("model","login");
            model.addAttribute("ismember",true);
            model.addAttribute("wrong","手机号或密码错误");
            model.addAttribute("goway","/myquestions");
            return "login";
        }
        return "myquestions";
    }
    @RequestMapping("/main")
    public String main(ModelMap model,HttpServletRequest request){
//        HttpSession session=request.getSession();//获取session并将userName存入session对象
//        String tel=(String)session.getAttribute("tel");
//        Object test=this.memberService.getmemberBytel(tel);
//        member member = (member)test;
//        model.addAttribute("member",member);

        model.addAttribute("opttype","main");
        return "myquestions";
    }
    @RequestMapping("/questions")
    public String questions(ModelMap model,HttpServletRequest request){
//        HttpSession session=request.getSession();//获取session并将userName存入session对象
//        String tel=(String)session.getAttribute("tel");
//        Object test=this.memberService.getmemberBytel(tel);
//        member member = (member)test;
//        model.addAttribute("member",member);

        model.addAttribute("opttype","questions");
        model.addAttribute("questionlist",this.investService.selectALL());
        return "myquestions";
    }

    @RequestMapping("/showinvest")//展示问卷
    public String showinvest(ModelMap model,HttpServletRequest request,@RequestParam(value="id",required = false) String id){
        model.addAttribute("invest",investService.selectinvestByid(Integer.valueOf(id)));
        model.addAttribute("i_q_a", i_q_aService.selectByPrimaryKey(Integer.valueOf(id)));//查询视图
        model.addAttribute("questionlist",questionService.selectByInvest_id(Integer.valueOf(id)));
        model.addAttribute("answerlist",answerService.selectByAll());
        model.addAttribute("opttype","showinvest");
        return "myquestions";
    }




}
