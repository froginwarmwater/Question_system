package com.example.demo.service;

import com.example.demo.model.answer;

import java.util.List;

public interface answerService {
    List<answer> selectByquestion_id(Integer question_id);

    List<answer> selectByAll();
}
