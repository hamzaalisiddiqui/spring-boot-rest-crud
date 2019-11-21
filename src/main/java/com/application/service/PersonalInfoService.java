package com.application.service;

import java.util.List;

import com.application.dto.PersonalInfo;

/**
 * @author Hamza Ali Siddiqui
 * @version 1.0
 * @since 2019
 */

public interface PersonalInfoService {

	List<PersonalInfo> findAll();

	PersonalInfo findOneById(int id);

	PersonalInfo addPersona(PersonalInfo persona);

	PersonalInfo editPersona(PersonalInfo personalInfo);

}
