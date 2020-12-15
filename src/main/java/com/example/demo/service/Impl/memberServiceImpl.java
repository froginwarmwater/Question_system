package com.example.demo.service.Impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.*;
import com.example.demo.service.*;
import javax.annotation.Resource;
import com.example.demo.repository.*;
@Service("memberService")
public class memberServiceImpl implements memberService {

    // 注入mapper类
    @Resource
    private memberMapper memberMapper;

    @Override
    public member getmemberById(Integer idno) {
        return memberMapper.selectByPrimaryKey(idno);
    }

    @Override
    public member getmemberBytel(String tel) {
        return memberMapper.selectBytel(tel);
    }

    @Override
    public member getmemberByemail(String email) {
        return memberMapper.selectByemail(email);
    }

    @Override
    public void addmember(member member) {
        memberMapper.addmember(member);
    }
}
