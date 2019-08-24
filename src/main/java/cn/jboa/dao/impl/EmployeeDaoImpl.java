package cn.jboa.dao.impl;

import cn.jboa.dao.EmployeeDao;
import cn.jboa.entity.Employee;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

    @Override
    public Employee checkUser(String sn, String pwd) {
        String hql = "from Employee where sn = ? and password = ?";
        List<Employee> objects = (List<Employee>) this.getHibernateTemplate().find(hql,sn,pwd);
        return objects!=null?objects.get(0):null;

    }



}
