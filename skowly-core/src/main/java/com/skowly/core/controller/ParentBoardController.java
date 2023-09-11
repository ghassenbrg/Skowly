package com.skowly.core.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skowly.core.model.CourseAssignment;
import com.skowly.core.model.Student;
import com.skowly.core.model.ui.CourseCard;
import com.skowly.core.repository.StudentRepository;
import com.skowly.core.service.CourseAssignementService;

@RestController
@RequestMapping("/parent-board")
public class ParentBoardController {

	@Autowired
	CourseAssignementService teacherAssignementService;
	@Autowired
	StudentRepository studentRepository;
	@GetMapping("/students/{id}/courses")
	public ResponseEntity<List<CourseCard>> getCourses(@PathVariable Long id) {
		List<CourseAssignment> courseAssignements = teacherAssignementService.getTeacherAssignementsByStudentId(id);

		if (courseAssignements == null) {
			return ResponseEntity.ok(new ArrayList<>());
		}
		List<CourseCard> courseCards = courseAssignements.stream().map(assignement -> {
			CourseCard couseCard = new CourseCard();
			couseCard.setTeacherName(assignement.getTeacher().getName());
			couseCard.setCourseName(assignement.getCourse().getCourseName());
			return couseCard;
		}).collect(Collectors.toList());
		return ResponseEntity.ok(courseCards);

	}
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){	
		return ResponseEntity.ok (studentRepository.findAll());
	}

}
