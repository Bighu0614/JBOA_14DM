package cn.jboa.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import cn.jboa.common.Constants;
import cn.jboa.entity.Employee;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class BaseAction extends ActionSupport implements ServletResponseAware{


	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {

	}
}
