package com.skowly.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.skowly.core.domain.model.School;
import com.skowly.core.service.SchoolService;

import java.util.List;

/**
 * This class defines a RESTful controller for managing school-related operations.
 */
@RestController
@RequestMapping("/schools")
public class SchoolRestController {

    @Autowired
    private SchoolService schoolService;

    /**
     * Get a list of all schools.
     *
     * @return A list of School objects representing all schools.
     */
    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    /**
     * Get a school by its unique identifier.
     *
     * @param id The unique identifier of the school to retrieve.
     * @return ResponseEntity containing the School if found, or a NOT_FOUND status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        School school = schoolService.getSchoolById(id);
        if (school == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "School not found");
        }
        return ResponseEntity.ok(school);
    }

    /**
     * Create a new school.
     *
     * @param school The School object representing the school to be created.
     * @return ResponseEntity containing the created School with a CREATED status.
     */
    @PostMapping
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        School createdSchool = schoolService.createSchool(school);
        	if(school == null) {
        		  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating school");
        	}
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchool);
    }

    /**
     * Update an existing school.
     *
     * @param id           The unique identifier of the school to be updated.
     * @param updatedSchool The School object containing updated information.
     * @return ResponseEntity containing the updated School if found, or a NOT_FOUND status if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School updatedSchool) {
        School school = schoolService.updateSchool(id, updatedSchool);
        if (school == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "School not found");
        }
        return ResponseEntity.ok(school);
    }

    /**
     * Delete a school by its unique identifier.
     *
     * @param id The unique identifier of the school to be deleted.
     * @return ResponseEntity with no content if the deletion is successful.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Exception handler for handling generic exceptions.
     *
     * @param e The exception to be handled.
     * @return ResponseEntity with an INTERNAL_SERVER_ERROR status and an error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
    }
}