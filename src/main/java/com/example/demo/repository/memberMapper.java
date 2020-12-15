package com.example.demo.repository;

import com.example.demo.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
public interface memberMapper {

    // 对应xml映射文件元素的ID
    member selectByPrimaryKey(Integer idno);

    member selectBytel(String tel);

    member selectByemail(String email);

    void addmember(member member);

}
