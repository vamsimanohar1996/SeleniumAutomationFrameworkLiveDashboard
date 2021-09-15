package org.personal.exceptions;

@SuppressWarnings("serial")
public class InvalidTestDataPathException extends FrameworkExceptions{
	
	
	public InvalidTestDataPathException(String message)
	{
		super(message);
	}
	
	public InvalidTestDataPathException(String message,Throwable cause)
	{
		super(message,cause);
	}


}
