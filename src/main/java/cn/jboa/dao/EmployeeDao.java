package cn.jboa.dao;


import cn.jboa.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee checkUser(String sn, String pwd);

}
