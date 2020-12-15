package com.example.demo.repository;

import com.example.demo.model.invest;

import java.util.List;

public interface investMapper {
    List<invest> selectAll();

    int addinvest(invest invest);

    invest selectinvestByid(Integer id);

    void deleteinvest(Integer id);
}
