package com.application.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	private static final String API_ADD_PERSONAL_INFO = "/personalInfo";
	private static final String API_EDIT_PERSONAL_INFO = "/personalInfo";
	private static final String API_DELETE_PERSONAL_INFO = "/personalInfo/{id}";

	@Autowired
	PersonalInfoService personaController;

	@GetMapping({ API_FETCH_ALL_PERSONAL_INFO })
	public ResponseEntity<BaseResponse<?>> getAllPersona() {

		List<PersonalInfo> personas = personaController.findAll();
		final BaseResponse<?> response = new BaseResponse<List<PersonalInfo>>(true, "Personal info list fetched successfully",
				personas);
		return new ResponseEntity<BaseResponse<?>>(response, HttpStatus.OK);

	}

	@GetMapping({ API_FETCH_PERSONAL_INFO })
	public ResponseEntity<BaseResponse<?>> getPersona(@PathVariable @NotBlank int id) {

		PersonalInfo persona = personaController.findOneById(id);
		final BaseResponse<?> response = new BaseResponse<PersonalInfo>(true, "Personal info fetched successfully", persona);
		return new ResponseEntity<BaseResponse<?>>(response, HttpStatus.OK);

	}

	@PostMapping({ API_ADD_PERSONAL_INFO })
	public ResponseEntity<BaseResponse<?>> addPersona(@RequestBody @Valid final PersonalInfo requestPersona) {
		PersonalInfo persona = personaController.addPersona(requestPersona);
		final BaseResponse<?> response = new BaseResponse<PersonalInfo>(true, "Personal info added successfully", persona);
		return new ResponseEntity<BaseResponse<?>>(response, HttpStatus.CREATED);

	}
	
	@PutMapping({ API_EDIT_PERSONAL_INFO })
	public ResponseEntity<BaseResponse<?>> editPersona(@RequestBody @Valid final PersonalInfo requestPersona) {
		PersonalInfo persona = personaController.editPersona(requestPersona);
		final BaseResponse<?> response = new BaseResponse<PersonalInfo>(true, "Personal info updated successfully", persona);
		return new ResponseEntity<BaseResponse<?>>(response, HttpStatus.OK);

	}
	
	@DeleteMapping({ API_DELETE_PERSONAL_INFO })
	public ResponseEntity<BaseResponse<?>> deletePersona(@PathVariable @NotBlank int id) {
		personaController.deletePersona(id);
		final BaseResponse<?> response = new BaseResponse<String>(true, "Personal info deleted successfully", null);
		return new ResponseEntity<BaseResponse<?>>(response, HttpStatus.OK);

	}
	
}
