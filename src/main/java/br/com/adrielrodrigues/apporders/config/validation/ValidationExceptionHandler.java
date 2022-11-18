package br.com.adrielrodrigues.apporders.config.validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ValidationExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	//invalid pathVariable
	@ResponseBody
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MessageExceptionHandler> pathError(NoSuchElementException exception){
		MessageExceptionHandler errorMessage = new MessageExceptionHandler(
				LocalDate.now(), HttpStatus.NOT_FOUND.value(),"Not Found");
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	//invalid pathVariable
	@ResponseBody
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<MessageExceptionHandler> pathError(EmptyResultDataAccessException exception){
		MessageExceptionHandler errorMessage = new MessageExceptionHandler(
				LocalDate.now(), HttpStatus.NOT_FOUND.value(),"Not Found");
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	//invalid pathVariable
	@ResponseBody
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<MessageExceptionHandler> pathError(MethodArgumentTypeMismatchException exception){
		MessageExceptionHandler errorMessage = new MessageExceptionHandler(
				LocalDate.now(), HttpStatus.NOT_FOUND.value(),"Not Found");
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	//invalid pathVariable
	@ResponseBody
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<MessageExceptionHandler> pathError(HttpRequestMethodNotSupportedException exception){
		MessageExceptionHandler errorMessage = new MessageExceptionHandler(
				LocalDate.now(), HttpStatus.METHOD_NOT_ALLOWED.value(),"Method Not allowed");
		return new ResponseEntity<>(errorMessage, HttpStatus.METHOD_NOT_ALLOWED);
	}	
	
	// invalid Json arguments
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<MessageExceptionHandler> jsonError(MethodArgumentNotValidException exception){
		List<MessageExceptionHandler> errorMessage = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e ->{
			
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			MessageExceptionHandler error = new MessageExceptionHandler(
					LocalDate.now(), HttpStatus.NOT_FOUND.value(), message, e.getField());
			errorMessage.add(error);					
		});
		
		return errorMessage;
	}
	
	

}
