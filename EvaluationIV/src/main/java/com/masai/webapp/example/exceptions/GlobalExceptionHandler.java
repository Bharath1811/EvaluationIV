package com.masai.webapp.example.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	/*@ExceptionHandler(InvalidMarksException.class)
	public ResponseEntity<String> myExceptionHandler(InvalidMarksException ex) {
		System.out.println("In My Exception Handler Method for Invalid marks...");
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}*/
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> validationHandler(MethodArgumentNotValidException ex){
		
		ErrorMessage error = new ErrorMessage();
		
		error.setLocalDateTime(LocalDateTime.now());
		error.setMessage("Validation Error");
		String msg = ex.getBindingResult().getFieldError().getDefaultMessage();
		error.setDetails(msg);
		
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorMessage> notFoundException(NoHandlerFoundException ex, WebRequest request){
		System.out.println("In My Exception Handler Method for No Handler...");
		ErrorMessage error = new ErrorMessage();
		error.setLocalDateTime(LocalDateTime.now());
		error.setMessage(ex.getMessage());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> otherExceptions(Exception ex){
		System.out.println("For all other types of exceptions...");
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
