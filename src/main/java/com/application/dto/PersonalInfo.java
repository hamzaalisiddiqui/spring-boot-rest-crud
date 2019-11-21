package com.application.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.application.enums.HairColor;
import com.application.validator.EnumValidator;

/**
 * @author Hamza Ali iddiqui
 * @version 1.0
 * @since 2019
 */

public class PersonalInfo {

	private Integer id;
	
	@NotBlank(message="name is required and should containd alphabets only")
	@Pattern(regexp = "[A-Za-z]+",message="lastName should contain alphabets only")
	private String name;
	
	@NotBlank(message="lastName is required and should containd alphabets only")
	@Pattern(regexp = "[A-Za-z]+",message="lastName should contain alphabets only")
	private String lastName;
	
	@NotBlank(message="lastName is required and should containd alphabets only")
	@Pattern(regexp="[A-Za-z0-9]+",message="address should contain alphanumeric characters only") 
	private String address;
	
	@NotBlank(message="simplePhoneNumber is required and should contain numeric only")
	@Pattern(regexp="[0-9]+",message="simplePhoneNumber should contain numeric characters only")
	private String simplePhoneNumber;
	
	@NotNull
	@EnumValidator(enumClass=HairColor.class, ignoreCase=true)
	private String hairColor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSimplePhoneNumber() {
		return simplePhoneNumber;
	}

	public void setSimplePhoneNumber(String simplePhoneNumber) {
		this.simplePhoneNumber = simplePhoneNumber;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address
				+ ", simplePhoneNumber=" + simplePhoneNumber + ", hairColor=" + hairColor + "]";
	}

	public PersonalInfo(Integer id, String name, String lastName, String address, String simplePhoneNumber,
			String hairColor) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.simplePhoneNumber = simplePhoneNumber;
		this.hairColor = hairColor;
	}

}
