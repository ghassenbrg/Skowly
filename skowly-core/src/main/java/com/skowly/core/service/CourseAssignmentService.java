package com.skowly.core.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skowly.core.model.Student;
import com.skowly.core.model.CourseAssignment;
import com.skowly.core.repository.StudentRepository;
import com.skowly.core.repository.CourseAssignmentRepository;

@Service
public class CourseAssignmentService {

	@Autowired
	CourseAssignmentRepository teacherAssignmentRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
    public List<CourseAssignment> getTeacherAssignementsByStudentId(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(Objects.nonNull(student) && Objects.nonNull(student.getClassGroup())) {
        	return student.getClassGroup().getCourseAssignments(); 
        }else {
        	return null;
        }
        
    }

	
	
}
