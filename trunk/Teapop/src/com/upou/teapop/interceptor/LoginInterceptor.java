package com.upou.teapop.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> sessionAttributes = invocation.getInvocationContext().getSession();
		if(sessionAttributes == null || sessionAttributes.get("user") == null){
			return "login";
		} else {
			if(!sessionAttributes.get("user").equals(null)){
				return invocation.invoke();
			} else {
				return  "login";
			}
		}
	}

}
