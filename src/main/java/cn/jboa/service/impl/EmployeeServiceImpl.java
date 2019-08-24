package cn.jboa.service.impl;

import cn.jboa.dao.EmployeeDao;
import cn.jboa.entity.Employee;
import cn.jboa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("esi")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public Employee checkUser(String sn, String pwd) {
        return employeeDao.checkUser(sn,pwd);
    }

}
