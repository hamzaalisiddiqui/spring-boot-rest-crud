package com.application.exception;

/**
 * @author hamza.siddiqui
 * @version 1.0
 * @since 2019
 */

public class PersonalInfoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PersonalInfoNotFoundException(String message) {
		super(message);
	}

}
