package com.app01.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.app01.services.exceptions.AuthorizationException;
import com.app01.services.exceptions.DataIntegrityException;
import com.app01.services.exceptions.FileException;
import com.app01.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler{
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> ObjectNotFound (ObjectNotFoundException e,
			HttpServletRequest request){
		StandardError erro = new StandardError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(),"Não encontrado",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity (DataIntegrityException e,
			HttpServletRequest request){
		StandardError erro = new StandardError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),"Integridade de Dados",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation (MethodArgumentNotValidException e,
			HttpServletRequest request){
		ValidationError erro = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"Erro de Validação", e.getMessage(),request.getRequestURI());
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			erro.addError(x.getField(), x.getDefaultMessage());
		
		}
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization (AuthorizationException e,
			HttpServletRequest request){
		StandardError erro = new StandardError(System.currentTimeMillis(),HttpStatus.FORBIDDEN.value(),"Acesso negado",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(erro);
	}
	
	@ExceptionHandler(FileException.class)
	public ResponseEntity<StandardError> file(FileException e,
			HttpServletRequest request){
		StandardError erro = new StandardError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),"Erro de arquivo",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(AmazonClientException.class)
	public ResponseEntity<StandardError> amzonClient(AmazonClientException e,
			HttpServletRequest request){
		StandardError erro = new StandardError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(), "Erro Amazon Client",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(AmazonS3Exception.class)
	public ResponseEntity<StandardError> amzonClientS3(AmazonS3Exception e,
			HttpServletRequest request){
		StandardError erro = new StandardError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),"Erro S3",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(AmazonServiceException.class)
	public ResponseEntity<StandardError> amzonService(AmazonServiceException e,
			HttpServletRequest request){
		
		HttpStatus code = HttpStatus.valueOf(e.getErrorCode());
		StandardError erro = new StandardError(System.currentTimeMillis(),code.value(), "Erro Amazon Service",
				e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(code).body(erro);
	}
}
