package com.manuscript.configuration.entities;

import java.util.Date;


public class ErrorMessage {

	private Date timestamp;
    private String message;
	public ErrorMessage(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}
    
    
}