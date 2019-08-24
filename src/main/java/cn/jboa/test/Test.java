package cn.jboa.test;

import cn.jboa.entity.ClaimVoucher;
import cn.jboa.entity.Employee;
import cn.jboa.service.ClaimVoucherService;
import cn.jboa.service.impl.ClaimVoucherServiceImpl;
import cn.jboa.service.EmployeeService;
import cn.jboa.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    @Autowired
    private EmployeeService eis = new EmployeeServiceImpl();
    @org.junit.Test
    public void test(){
        ApplicationContext ac = new  ClassPathXmlApplicationContext("ApplicationContext.xml");
        ClaimVoucherService cv = (ClaimVoucherService)ac.getBean("cvi");
// 1       ClaimVoucher cvv = new ClaimVoucher();
//        cvv.setCreate_sn("001");
//        List<ClaimVoucher> claimVouchers = cv.showInfo(cvv, 0, 5);
//        System.out.println(claimVouchers.get(0).getCreator());
        ClaimVoucher cvv = new ClaimVoucher();
        cvv.setId(196);
    }
}
