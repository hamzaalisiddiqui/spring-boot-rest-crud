package com.application.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dto.BaseResponse;
import com.application.dto.PersonalInfo;
import com.application.service.PersonalInfoService;

/**
 * @author Hamza Ali Siddiqui
 * @version 1.0
 * @since 2019
 */

@RestController
@RequestMapping(value = "/")
public class PersonalInfoController {

	private static final String API_FETCH_ALL_PERSONAL_INFO = "/personalInfo";
	private static final String API_FETCH_PERSONAL_INFO = "/personalInfo/{id}";

	@Autowired
	PersonalInfoService personaController;

	@GetMapping({ API_FETCH_ALL_PERSONAL_INFO })
	public ResponseEntity<BaseResponse<?>> getAllPersona() {

		List<PersonalInfo> personas = personaController.findAll();
		final BaseResponse<?> response = new BaseResponse<List<PersonalInfo>>(true, "Data Fetched Successfully",
				personas);
		return new ResponseEntity<BaseResponse<?>>(response, HttpStatus.OK);

	}

	@GetMapping({ API_FETCH_PERSONAL_INFO })
	public ResponseEntity<BaseResponse<?>> getPersona(@PathVariable @NotBlank int id) {

		PersonalInfo persona = personaController.findOneById(id);
		final BaseResponse<?> response = new BaseResponse<PersonalInfo>(true, "Data Fetched Successfully", persona);
		return new ResponseEntity<BaseResponse<?>>(response, HttpStatus.OK);

	}

}
