package com.upou.teapop.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.upou.teapop.constants.EmailConstants;

public class EmailService {
	
	private String teapopEmail;
	
	private String teapopPassword;
	
	private String emailMessage;
	
	private String starttls;
	
	private String auth;
	
	private String host;
	
	private String port;
	
	public void sendEmail(String name, String emailTo, String messageFrom, String contactNumber) throws Exception{
        
		loadPropertiesFile();
		
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable",  starttls);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(teapopEmail, teapopPassword);
            }
          });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(teapopEmail));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(emailTo));
            message.setSubject("Teapop Cafe");
            
            message.setContent("Hi " + name + "<br><br>"
            		             + emailMessage + "<br><br>"
            		             + "Thank You, <br>"
            		             + "Teapop - Tea and More", "text/html");
            Transport.send(message);
            
            message.setFrom(new InternetAddress(teapopEmail));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(teapopEmail));
            message.setSubject("Customer Comments/Suggestions from " + name);
            
            message.setContent("EMAIL SENDER: " + emailTo 
            		           + "<br><br>" + "CONTACT #: " + contactNumber
            		           + "<br><br>" + "MESSAGE: " + messageFrom, "text/html");
            Transport.send(message);
            


        } catch (MessagingException e) {
            throw new Exception(e);
        } 
	}
	
	private void loadPropertiesFile(){
		try {
			Properties prop = new Properties();
			InputStream in = getClass().getClassLoader().getResourceAsStream("email.properties");
			prop.load(in);
			emailMessage =  prop.getProperty(EmailConstants.TEAPOP_EMAIL_MESSAGE);
			teapopEmail = prop.getProperty(EmailConstants.TEAPOP_EMAIL);
			teapopPassword = prop.getProperty(EmailConstants.TEAPOP_EMAIL_PASSWORD);
			starttls = prop.getProperty(EmailConstants.STARTTLS_ENABLE);
			auth = prop.getProperty(EmailConstants.SMTP_AUTH);
			host = prop.getProperty(EmailConstants.EMAIL_HOST);
			port = prop.getProperty(EmailConstants.EMAIL_PORT);
			
			
			System.out.println(emailMessage);
			System.out.println(teapopEmail);
			System.out.println(teapopPassword);
			System.out.println(starttls);
			System.out.println(auth);
			System.out.println(host);
			System.out.println(port);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
       
	}
}
