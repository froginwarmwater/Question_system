package com.example.demo.service;

import com.example.demo.model.*;

public interface memberService {

    public member getmemberById(Integer idno);

    public member getmemberBytel(String tel);

    public member getmemberByemail(String email);

    public void addmember(member member);
}
