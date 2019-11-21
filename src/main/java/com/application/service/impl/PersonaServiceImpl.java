package com.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.application.dto.PersonalInfo;
import com.application.exception.PersonalInfoNotFoundException;
import com.application.service.PersonalInfoService;

/**
 * @author hamza.siddiqui
 * @version 1.0
 * @since 2019
 */

@Service
public class PersonaServiceImpl implements PersonalInfoService {
	private static List<PersonalInfo> personalInfoList = new ArrayList<>();

	private static Integer counter = 0;
	static {
		personalInfoList.add(new PersonalInfo(++counter, "Add", "John", "Karachi", "123456789", "brown"));
		personalInfoList.add(new PersonalInfo(++counter, "John", "Doe", "Atlanta", "123456789", "black"));
		personalInfoList.add(new PersonalInfo(++counter, "Lorem", "Ipsum", "Islamabad", "123456789", "white"));
	}

	@Override
	public List<PersonalInfo> findAll() {
		return personalInfoList;
	}

	@Override
	public PersonalInfo findOneById(int id) {
		for (PersonalInfo persona : personalInfoList)
			if (persona.getId() == id)
				return persona;
		throw new PersonalInfoNotFoundException("No Such Record Exists");
	}

}
