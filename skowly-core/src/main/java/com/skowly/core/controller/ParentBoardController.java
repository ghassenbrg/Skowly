package com.skowly.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skowly.core.domain.model.CourseInstance;
import com.skowly.core.domain.model.Student;
import com.skowly.core.domain.repository.StudentRepository;
import com.skowly.core.model.ui.CourseCard;
import com.skowly.core.service.CourseAssignmentService;

@RestController
@RequestMapping("/parent-board")
public class ParentBoardController {

	@Autowired
	CourseAssignmentService teacherAssignmentService;
	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/students/{id}/courses")
	public ResponseEntity<List<CourseCard>> getCourses(@PathVariable Long id) {
		List<CourseInstance> courseInstances = teacherAssignmentService.getCourseInstancesByStudentId(id);

		if (courseInstances == null) {
			return ResponseEntity.ok(new ArrayList<>());
		}
		List<CourseCard> courseCards = courseInstances.stream().map(courseIntance -> {
			CourseCard couseCard = new CourseCard();
			// couseCard.setTeacherName(courseIntance.getInstructor().getName());
			// couseCard.setCourseName(courseIntance.getCourse().getCourseName());
			return couseCard;
		}).toList();
		return ResponseEntity.ok(courseCards);

	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.ok(studentRepository.findAll());
	}

}
