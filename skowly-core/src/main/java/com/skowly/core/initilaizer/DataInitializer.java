package com.skowly.core.initilaizer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.skowly.core.domain.model.*;
import com.skowly.core.domain.repository.*;

@Component
@ConditionalOnProperty(name = "data.initializer.enabled", havingValue = "true", matchIfMissing = true)
public class DataInitializer implements CommandLineRunner {
    private final  ClassGroupRepository classGroupRepository;
    private final ClassroomRepository classroomRepository;
    private final CourseRepository courseRepository;
    private final CourseInstanceRepository courseAssignmentRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public DataInitializer(
            ClassGroupRepository classGroupRepository,
            ClassroomRepository classroomRepository,
            CourseRepository courseRepository,
            CourseInstanceRepository courseAssignmentRepository,
            StudentRepository studentRepository,
            TeacherRepository teacherRepository) {
        this.classGroupRepository = classGroupRepository;
        this.classroomRepository = classroomRepository;
        this.courseRepository = courseRepository;
        this.courseAssignmentRepository = courseAssignmentRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void run(String... args) {
    	/*
    	// Insert data into the database for Classroom
        Classroom classroom = new Classroom();
        classroom.setClassName("2eme");
        classroomRepository.save(classroom);

        // Insert data into the database for ClassGroup
        ClassGroup classGroup1 = new ClassGroup();
        classGroup1.setGroupName("A");
        classGroup1.setClassroom(classroom);
        classGroupRepository.save(classGroup1);
        
        ClassGroup classGroup2 = new ClassGroup();
        classGroup2.setGroupName("B");
        classGroup2.setClassroom(classroom);
        classGroupRepository.save(classGroup2);

        
        // Insert data into the database for Student
        Student student1 = new Student();
        student1.setName("karim");
        student1.setClassGroup(classGroup1);
        studentRepository.save(student1);
        
        Student student2 = new Student();
        student2.setName("dhia");
        student2.setClassGroup(classGroup1);
        studentRepository.save(student2);
        
        Student student3 = new Student();
        student3.setName("ghassen");
        student3.setClassGroup(classGroup1);
        studentRepository.save(student3);
        
        
        // Insert data into the database for Teacher
        Teacher teacher1 = new Teacher();
        teacher1.setName("salah");
        teacherRepository.save(teacher1);
        
        Teacher teacher2 = new Teacher();
        teacher2.setName("mahmoud");
        teacherRepository.save(teacher2);
       
        // Insert data into the database for Course
        Course course1 = new Course();
        course1.setClassroom(classroom);
        course1.setCourseName("JAVA");
        courseRepository.save(course1);
        
        Course course2 = new Course();
        course2.setClassroom(classroom);
        course2.setCourseName("Spring");
        courseRepository.save(course2);
        

        // Insert data into the database for CourseAssignment
        CourseAssignment courseAssignment1 = new CourseAssignment();
        courseAssignment1.setClassGroup(classGroup1);
        courseAssignment1.setTeacher(teacher1);
        courseAssignment1.setCourse(course1);
        courseAssignmentRepository.save(courseAssignment1);
        
        CourseAssignment courseAssignment2 = new CourseAssignment();
        courseAssignment2.setClassGroup(classGroup1);
        courseAssignment2.setTeacher(teacher2);
        courseAssignment2.setCourse(course2);
        courseAssignmentRepository.save(courseAssignment2);
        */
       
    }
}
