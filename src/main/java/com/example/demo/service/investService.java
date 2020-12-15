package com.example.demo.service;

import com.example.demo.model.invest;

import java.util.List;

public interface investService {

    public List<invest> selectALL();

    public int addinvest(invest invest);

    invest selectinvestByid(Integer id);

    void deleteinvest(Integer id);
}
