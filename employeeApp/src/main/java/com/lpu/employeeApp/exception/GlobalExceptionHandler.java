package com.lpu.employeeApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Map<String,String>> handleArithmeticExp(ArithmeticException e)
	{
		Map<String,String> mp = new HashMap<String,String>();
		mp.put("Error", e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mp);
	}
	
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<Map<String,String>> handleCompanyNotFoundExp(CompanyNotFoundException e)
	{
		Map<String,String> mp = new HashMap<String,String>();
		mp.put("Error", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mp);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Map<String,String>> handleEmpNotFoundExp(EmployeeNotFoundException e)
	{
		Map<String,String> mp = new HashMap<String,String>();
		mp.put("Error", e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mp);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleExp(MethodArgumentNotValidException e)
	{
		Map<String,String> mp = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(error -> mp.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mp);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,String>> handleExps(Exception e)
	{
		Map<String,String> mp = new HashMap<String,String>();
		mp.put("Error", e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mp);
	}
}
