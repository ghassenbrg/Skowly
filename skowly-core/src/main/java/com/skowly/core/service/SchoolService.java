package com.skowly.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skowly.core.domain.model.School;
import com.skowly.core.domain.repository.SchoolRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class SchoolService {

	@Autowired
	UserService userService;
	
    @Autowired
    private SchoolRepository schoolRepository;
    

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

	@Transactional
	public School createSchool(School school) {
		school = schoolRepository.save(school);
		try {
			userService.createSchoolAdminUser(school.getPrincipal().getPrincipalName(),
					school.getPrincipal().getPrincipalEmail(), school.getId().toString());
			return school;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

    public School updateSchool(Long id, School updatedSchool) {
        School existingSchool = getSchoolById(id);
        if (existingSchool == null) {
            return null; // Handle not found scenario
        }
        
        // Update the existing school's properties with updatedSchool
        existingSchool.setName(updatedSchool.getName());
        existingSchool.setDescription(updatedSchool.getDescription());
        existingSchool.setAddress(updatedSchool.getAddress());
        existingSchool.setPhoneNumber(updatedSchool.getPhoneNumber());
        existingSchool.setWebsite(updatedSchool.getWebsite());
        existingSchool.setEmail(updatedSchool.getEmail());
        existingSchool.setPrincipal(updatedSchool.getPrincipal());
        existingSchool.setTotalStudents(updatedSchool.getTotalStudents());
        existingSchool.setTotalTeachers(updatedSchool.getTotalTeachers());
        existingSchool.setMapsPosition(updatedSchool.getMapsPosition());
        existingSchool.setFoundingDate(updatedSchool.getFoundingDate());
        existingSchool.setAccreditation(updatedSchool.getAccreditation());
        existingSchool.setFacilities(updatedSchool.getFacilities());
        existingSchool.setExtracurricularActivities(updatedSchool.getExtracurricularActivities());
        existingSchool.setAdmissionProcess(updatedSchool.getAdmissionProcess());
        
        // Save the updated school entity
        return schoolRepository.save(existingSchool);
    }

    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
}