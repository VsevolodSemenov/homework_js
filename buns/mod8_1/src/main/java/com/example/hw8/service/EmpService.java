package com.example.hw8.service;

import com.example.hw8.entity.Emp;

import java.util.List;

public interface EmpService {
    public void save(Emp employee);

    public void delete(int id);

    public List<Emp> getAll();

    public Emp getEmployee(int id);
}
