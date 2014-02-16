package com.upou.teapop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.data.User;


public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	private User user;
	private Map<String, Object> session;
	
	public String dashboard(){
		return SUCCESS;
	}
	
	public String login(){
		//TEMPORARY
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){
			user.setFirstName("Mary Joy");
			user.setLastName("Pascual");
			session.put(DisplayConstants.SESSION_USER, user.getDisplayName());
			return SUCCESS;
		} else{
			addActionError(ErrorConstants.LOGIN_ERROR);
			return LOGIN;
		}
		
	}
	
	public String logout(){
		session.remove("user");
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		 this.session = map;
	}
	

}