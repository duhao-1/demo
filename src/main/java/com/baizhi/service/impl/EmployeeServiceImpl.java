package com.baizhi.service.impl;

import com.baizhi.dao.EmployeeMapper;
import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeMapper.selectAll();
        return employees;
    }

    @Override
    public void add(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public Employee getById(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    @Override
    public void remove(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }
}
