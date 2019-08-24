package cn.jboa.action;


import cn.jboa.entity.Employee;
import cn.jboa.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class EmployeeAction extends BaseAction{
    private EmployeeService esi;

    public EmployeeService getEsi() {
        return esi;
    }

    public void setEsi(EmployeeService esi) {
        this.esi = esi;
    }

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private String random;

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    /**
     * 根据工号和密码登陆
     * @return 是否存在
     */
    public String login(){
        Employee employee = this.esi.checkUser(this.employee.getSn(), this.employee.getPassword());
        String picCode = (String)ActionContext.getContext().getSession().get("picCode");
        if (employee != null&&random.equals(picCode)) {
            Map session = (Map)ActionContext.getContext().getSession();
            session.put("employee_position", employee.getSysPosition().getNameCn());
            session.put("employee",employee);
        }else {
            addActionError("输入信息有误！！！");
            return INPUT;
        }
        return SUCCESS;
    }
}
