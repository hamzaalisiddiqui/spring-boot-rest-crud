package com.application.exception;

import java.util.Date;
import java.util.List;

/**
 * @author hamza.siddiqui
 * @version 1.0
 * @since 2019
 */

public class ExceptionResponse {
	private Date timeStamp;
	private String message;
	private List<String> exceptionDetails;

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getExceptionDetails() {
		return exceptionDetails;
	}

	public void setExceptionDetails(List<String> exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
	}

	public ExceptionResponse(Date timeStamp, String message, List<String> exceptionDetails) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.setExceptionDetails(exceptionDetails);
	}

}
