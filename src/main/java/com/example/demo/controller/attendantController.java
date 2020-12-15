package com.example.demo.controller;

import com.example.demo.model.attendant;
import com.example.demo.model.invest;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
@RequestMapping("/attendant")
public class attendantController {

//    // 注入mapper类
//    @Resource
//    private attendantService attendantService;
//
//    @RequestMapping(value="{idno}", method= RequestMethod.GET, produces="application/json")
//    public attendant getUser(@PathVariable String idno) throws Exception {
//        attendant attendant = this.attendantService.getattendantByidno(idno);
//        return attendant;
//    }
//
    @Resource
    private com.example.demo.service.investService investService;
    @Resource
    private com.example.demo.service.attendantService attendantService;
    @Resource
    private com.example.demo.service.i_q_aService i_q_aService;
    @Resource
    private com.example.demo.service.answerService answerService;
    @Resource
    private com.example.demo.service.questionService questionService;

    @RequestMapping(path={"","/"})//登录传递
    public  String index(@RequestParam(value="tel") String idno, @RequestParam(value="pwd") String pwd, HttpServletRequest request, ModelMap model){
        Object test=this.attendantService.getattendantByidno(idno);
        HttpSession session=request.getSession();
        if(test==null){
            model.addAttribute("model","Clogin");
            model.addAttribute("ismember",true);
            model.addAttribute("wrong","账号非管理员账号");
            model.addAttribute("goway","/attendant");
            return "login";
        }
        attendant attendant = (attendant)test;
        if(attendant.getPwd().equals(pwd)){
            session.setAttribute("attendantName", attendant.getUsername());
            session.setAttribute("idno",attendant.getIdno());
            model.addAttribute("attendant",attendant);
            model.addAttribute("opttype","main");
        }
        else {
            model.addAttribute("model","Clogin");
            model.addAttribute("ismember",true);
            model.addAttribute("wrong","账号或密码错误");
            model.addAttribute("goway","/attendant");
            return "login";
        }
        return "attendant";
    }

    @RequestMapping("/main")//我的信息
    public String main(ModelMap model,HttpServletRequest request){
//        HttpSession session=request.getSession();//获取session并将userName存入session对象
//        String idno=(String)session.getAttribute("idno");
//        Object test=this.attendantService.getattendantByidno(idno);
//        attendant attendant = (attendant)test;
//        model.addAttribute("attendant",attendant);
        model.addAttribute("opttype","main");
        return "attendant";
    }


    @RequestMapping("/selectinvest")//查询问卷
    public String questions(ModelMap model,HttpServletRequest request){
//        HttpSession session=request.getSession();//获取session并将userName存入session对象
//        String idno=(String)session.getAttribute("idno");
//        Object test=this.attendantService.getattendantByidno(idno);
//        attendant attendant = (attendant)test;
//        model.addAttribute("attendant",attendant);
        model.addAttribute("opttype","selectinvest");
        model.addAttribute("questionlist",this.investService.selectALL());
        return "attendant";
    }

    @RequestMapping("/addinvest")//添加问卷页面跳转
    public String addquestions(ModelMap model,HttpServletRequest request){
//        HttpSession session=request.getSession();//获取session并将userName存入session对象
//        String idno=(String)session.getAttribute("idno");
//        Object test=this.attendantService.getattendantByidno(idno);
//        attendant attendant = (attendant)test;
//        model.addAttribute("attendant",attendant);
        model.addAttribute("opttype","addinvest");
        return "attendant";
    }

    @RequestMapping("/showinvest")//添加问题 跳转
    public String addtitle(@RequestParam(value="title",required = false) String title,@RequestParam(value="id",required = false) String invest_id,ModelMap model,HttpServletRequest request){
//        HttpSession session=request.getSession();//获取session并将userName存入session对象
//        String idno=(String)session.getAttribute("idno");
//        Object test=this.attendantService.getattendantByidno(idno);
//        attendant attendant = (attendant)test;
//        model.addAttribute("attendant",attendant);
        Integer id;
        if(title!=null) {
            invest invest = new invest();
            invest.setTitle(title);
            investService.addinvest(invest);
             id= invest.getId();
        }
        else
            id=Integer.valueOf(invest_id);
        model.addAttribute("invest",investService.selectinvestByid(Integer.valueOf(id)));
        model.addAttribute("i_q_a", i_q_aService.selectByPrimaryKey(Integer.valueOf(id)));//查询视图
        model.addAttribute("questionlist",questionService.selectByInvest_id(Integer.valueOf(id)));
        model.addAttribute("answerlist",answerService.selectByAll());
        model.addAttribute("opttype","showinvest");
        return "attendant";
    }

    @RequestMapping("/deleteinvest")//删除问卷
    public String deleteinvest(@RequestParam(value="id") String id,ModelMap model,HttpServletRequest request){
        investService.deleteinvest(Integer.valueOf(id));
        model.addAttribute("opttype","selectinvest");
        model.addAttribute("questionlist",this.investService.selectALL());
        return "attendant";
    }

    @RequestMapping("/addquestion")//删除问卷
    public String addquestion(@RequestParam(value="id") String id,ModelMap model,HttpServletRequest request){
        model.addAttribute("opttype","addquestion");
        model.addAttribute("id",id);
        return "attendant";
    }

    @RequestMapping("/changeinvest")//修改问卷
    public String changeinvest(@RequestParam(value="id") String id,ModelMap model,HttpServletRequest request){


        return "attendant";
    }

}