package br.com.adrielrodrigues.apporders.config.validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
