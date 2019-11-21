package com.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.application.dto.BaseResponse;

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

}
