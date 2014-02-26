package com.upou.teapop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.upou.teapop.util.EmailService;

public class SendEmailAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String email;
	
	private String contactNumber;
	
	private String questionsAndComments;
	
	
	public String execute() {
		
		EmailService service = new EmailService();
		try {
			service.sendEmail(name, email, questionsAndComments, contactNumber);
			addActionMessage("EMAIL SENT");
		} catch (Exception e) {
			addActionError("EMAIL SENDING FAILED");
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getQuestionsAndComments() {
		return questionsAndComments;
	}

	public void setQuestionsAndComments(String questionsAndComments) {
		this.questionsAndComments = questionsAndComments;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
