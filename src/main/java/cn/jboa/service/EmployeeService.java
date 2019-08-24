package cn.jboa.service;


import cn.jboa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee checkUser(String sn, String pwd);

}
