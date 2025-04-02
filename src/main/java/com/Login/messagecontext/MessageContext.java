package com.Login.messagecontext;

import org.springframework.stereotype.Component;

@Component
public class MessageContext {
	  public static final String INVALID_USERNAME_OR_PASSWORD = "Invalid username or password";
	    
	    // Add more messages as needed
	    public static final String USER_NOT_FOUND = "User not found";
	    public static final String LOGIN_SUCCESSFUL = "Login successful";
	    public static final String ACCOUNT_LOCKED = "Account is locked due to too many failed login attempts";
	  
}
