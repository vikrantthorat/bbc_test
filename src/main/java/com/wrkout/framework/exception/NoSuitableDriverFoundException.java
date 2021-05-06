package com.wrkout.framework.exception;

/**
 * @author krana
 *
 */
public class NoSuitableDriverFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuitableDriverFoundException(String message) {
		super(message);
	}
	
	public NoSuitableDriverFoundException(){
		this("");
	}

}
