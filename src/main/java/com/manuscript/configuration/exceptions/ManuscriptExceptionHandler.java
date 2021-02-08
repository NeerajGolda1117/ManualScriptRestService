package com.manuscript.configuration.exceptions;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.manuscript.configuration.entities.ErrorMessage;

import java.util.Date;


@RestControllerAdvice
public class ManuscriptExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {ManuscriptException.class})
	public ResponseEntity<Object>  handleManuscriptException(ManuscriptException manuscriptexception , WebRequest webreq)
	{
		String errorMessageDescription = "SPECIFIC_EXCEPTION: " +  (manuscriptexception.getLocalizedMessage()!=null ? manuscriptexception.getLocalizedMessage() : manuscriptexception.toString());
		
		
		ErrorMessage errormessage = new ErrorMessage(new Date(),errorMessageDescription);
		
		return new ResponseEntity<>(errormessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
