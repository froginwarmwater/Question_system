package com.example.demo.controller;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.example.demo.model.*;
import com.example.demo.service.*;
@RestController
@EnableAutoConfiguration
@RequestMapping("/member")
public class memberController {

    // 注入mapper类
    @Resource
    private memberService memberService;

    @RequestMapping(value="{idno}", method= RequestMethod.GET, produces="application/json")
    public member getUser(@PathVariable Integer idno) throws Exception {
        member member = this.memberService.getmemberById(idno);
        return member;
    }

}