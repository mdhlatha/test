package namesearch.exception;

import java.io.Serializable;

public class NameSearchException extends Exception implements Serializable { 
	
	public NameSearchException(String message) {
		super(message);
	}
	public NameSearchException(String message,Throwable cause) {
		super(message,cause);
	}
	public String getMessage()
	{
		return super.getMessage();
	}

}
