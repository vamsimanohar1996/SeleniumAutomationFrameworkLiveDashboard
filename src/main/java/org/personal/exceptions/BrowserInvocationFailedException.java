package org.personal.exceptions;

@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends FrameworkExceptions {

	public BrowserInvocationFailedException(String message) {
		super(message);
	}
	
	public BrowserInvocationFailedException(String message, Throwable cause) {
		super(message,cause);
	}
	


}
