package com.yong.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.yong.blog.dto.ResponseDto;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	
	// can handle all of exception
	@ExceptionHandler(value=Exception.class)
	public ResponseDto<String> handleArgumentException(IllegalArgumentException e) {
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
	}
}
