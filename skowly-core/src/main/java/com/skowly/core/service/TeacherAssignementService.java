package com.skowly.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skowly.core.model.Student;
import com.skowly.core.model.TeacherAssignment;
import com.skowly.core.repository.StudentRepository;
import com.skowly.core.repository.TeacherAssignementRepository;

@Service
public class TeacherAssignementService {

	@Autowired
	TeacherAssignementRepository teacherAssignementRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
    public List<TeacherAssignment> getTeacherAssignementsByStudentId(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(Objects.nonNull(student) && Objects.nonNull(student.getClassroom())) {
        	return student.getClassroom().getTeacherAssignments() ;
        }else {
        	return null;
        }
        
    }

	
	
}
