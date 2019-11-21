package com.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author hamza.siddiqui
 * @version 1.0
 * @since 2019
 */

@JsonInclude(value = Include.ALWAYS)
public class BaseResponse<T> {
	private boolean success;
	private String message;
	private T content;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public BaseResponse(boolean success, String message, T content) {
		super();
		this.success = success;
		this.message = message;
		this.content = content;
	}

}
