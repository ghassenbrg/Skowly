package com.skowly.core.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skowly.core.domain.model.CourseInstance;
import com.skowly.core.domain.model.Student;
import com.skowly.core.domain.repository.CourseInstanceRepository;
import com.skowly.core.domain.repository.StudentRepository;

@Service
public class CourseAssignmentService {

	@Autowired
	CourseInstanceRepository teacherAssignmentRepository;

	@Autowired
	StudentRepository studentRepository;

	public List<CourseInstance> getCourseInstancesByStudentId(Long id) {
		Student student = studentRepository.findById(id).orElse(null);

		if (Objects.nonNull(student)) {
			return student.getEnrollments().stream()
					.map(e -> e.getCourseInstance())
					.toList();
		} else {
			return Collections.emptyList();
		}

	}

}
