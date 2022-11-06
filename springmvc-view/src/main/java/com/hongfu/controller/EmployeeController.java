package com.hongfu.controller;

import com.hongfu.dao.DepartmentDao;
import com.hongfu.dao.EmployeeDao;
import com.hongfu.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Map<String, Object> map){
        map.put("employees", employeeDao.getAll());
        return "list";
    }

    //跳转到员工添加页面的方法，需要初始化一些字典数据，比如部门信息
    @GetMapping("/emp")
    public String toAddEmp(Map<String,Object> map){
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts",departments);
        return "add";
    }
}
