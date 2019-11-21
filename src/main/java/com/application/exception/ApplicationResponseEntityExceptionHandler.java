package com.application.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ValidationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.application.dto.BaseResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

/**
 * @author hamza.siddiqui
 * @version 1.0
 * @since 2019
 */

@ControllerAdvice
@RestController
public class ApplicationResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ PersonalInfoNotFoundException.class })
	public ResponseEntity<BaseResponse<?>> personaNotFound(PersonalInfoNotFoundException exception) {
		final BaseResponse<?> response = new BaseResponse<String>(false, exception.getMessage(), null);
		return new ResponseEntity<BaseResponse<?>>(response, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = exception.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		return new ResponseEntity<>(new ExceptionResponse(new Date(), "Request Validation Failed", errors), status);

	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> handleAllException(ValidationException exception) {
		List<String> errors = new ArrayList<String>();
		errors.add(exception.getMessage());
		return new ResponseEntity<>(new ExceptionResponse(new Date(), "Request Validation Failed", errors),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<Object> handleAllException(InvalidFormatException exception) {
		List<String> errors = new ArrayList<String>();
		errors.add(exception.getMessage());
		return new ResponseEntity<>(new ExceptionResponse(new Date(), "Request Validation Failed", errors),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception exception) {
		List<String> errors = new ArrayList<String>();
		errors.add(exception.getMessage());
		return new ResponseEntity<>(new ExceptionResponse(new Date(), "Request Validation Failed", errors),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
