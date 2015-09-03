package com.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.entity.Users;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UsersDAO;
import com.service.impl.UsersDAOImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users users = new Users();
	
	public String login(){
		UsersDAO udao = new UsersDAOImpl();
		if(udao.usersLogin(users)){
			
			//在session中保存用户名
			
			session.setAttribute("loginUsername", users.getUsername());
			return "login_success";
		}else{
			return "login_failure";
		}
			
		
	}
	
	@SkipValidation
	//用户注销方法
	public String logout(){
		if(session.getAttribute("loginUsername")!=null){
			session.removeAttribute("loginUsername");
		}
		return "logout_success";
	}
	
	
	//表单验证
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//用户名不能为空
		if("".equals(users.getUsername().trim())){
			this.addFieldError("usernameError", "用户名不能为空");
		}
		if(users.getPassword().length()<3){
			this.addFieldError("passwordError", "密码长度不能少于3位");
		}
	}
	
	
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.users;
	}

	
	
}
