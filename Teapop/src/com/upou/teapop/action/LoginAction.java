package com.upou.teapop.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.constants.DisplayConstants;
import com.upou.teapop.constants.ErrorConstants;
import com.upou.teapop.data.LoginData;
import com.upou.teapop.data.UserData;


public class LoginAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	private LoginData login;
	private Map<String, Object> session;
	
	public String dashboard(){
		return SUCCESS;
	}
	
	public String login(){
		//TEMPORARY
		if(login.getUsername().equals("admin") && login.getPassword().equals("admin")){
			UserData user = new UserData();
			user.setFirstName("Mary Joy");
			user.setLastName("Pascual");
			login.setUser(user);
			session.put(DisplayConstants.SESSION_USER, login.getUser().getDisplayName());
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

	public LoginData getLogin() {
		return login;
	}

	public void setLogin(LoginData login) {
		this.login = login;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		 this.session = map;
	}
	

}