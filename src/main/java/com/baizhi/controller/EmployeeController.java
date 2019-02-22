package com.baizhi.controller;

import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/showAll")
    public String showAll(HttpServletRequest req) {
        List<Employee> all = employeeService.getAll();
        req.setAttribute("employees", all);
        return "forward:/emplist.jsp";
    }

    @RequestMapping("/add")
    public String add(Employee employee) {
        employeeService.add(employee);
        return "redirect:/employee/showAll";
    }

    @RequestMapping("/update")
    public String update(Employee employee) {
        employeeService.update(employee);
        return "redirect:/employee/showAll";
    }

    @RequestMapping("/getById")
    public String getById(Integer id, HttpServletRequest req) {
        Employee byId = employeeService.getById(id);
        req.setAttribute("employees", byId);
        return "forward:/updateEmp.jsp";
    }

    @RequestMapping("remove")
    public String remove(Integer id) {
        employeeService.remove(id);
        return "redirect:/employee/showAll";
    }
}
