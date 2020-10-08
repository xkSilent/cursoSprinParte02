package com.app01.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fieldMessageString;
	private String message;
	
	public FieldMessage() {}

	public FieldMessage(String fieldMessageString, String message) {
		super();
		this.fieldMessageString = fieldMessageString;
		this.message = message;
	}

	public String getFieldMessageString() {
		return fieldMessageString;
	}

	public void setFieldMessageString(String fieldMessageString) {
		this.fieldMessageString = fieldMessageString;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
