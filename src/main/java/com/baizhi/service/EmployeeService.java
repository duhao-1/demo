package com.baizhi.service;

import com.baizhi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    void add(Employee employee);

    void update(Employee employee);

    Employee getById(Integer id);

    void remove(Integer id);
}
