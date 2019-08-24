package cn.jboa.entity;

import java.util.HashSet;
import java.util.Set;
/**
 * 部门实体类
 */
@SuppressWarnings("unchecked")
public class Department implements java.io.Serializable {

    private static final long serialVersionUID = -4386159382927256061L;
    private Integer id;
    private String name;
    private Set sysEmployees = new HashSet(0);

    /** default constructor */
    public Department() {
    }

    /** minimal constructor */
    public Department(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getSysEmployees() {
        return this.sysEmployees;
    }

    public void setSysEmployees(Set sysEmployees) {
        this.sysEmployees = sysEmployees;
    }

}