package com.nlogneg.FilterFramework.exceptions;

public class CannotFlushOutputPinException extends Exception{

	/**
	 * Generated serialization ID
	 */
	private static final long serialVersionUID = -5990879395165461897L;
	
	public CannotFlushOutputPinException(){
		super("Cannot flush Output Pins");
	}
	
	public CannotFlushOutputPinException(String message){
		super(message);
	}
}
