package psu.se411.practice2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psu.se411.practice2.model.Course;
import psu.se411.practice2.service.ClassService;

//this is the second practice	

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

	private final ClassService classService;

	public CourseController(ClassService classService) {
		this.classService = classService;
	}

	@GetMapping()
	public ResponseEntity<Iterable<Course>> getAllCourses() {
		Iterable<Course> courses = classService.getAllCourses();
		return ResponseEntity.ok(courses);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Optional<Course> course = classService.getCourseById(id);
		if (course != null) {
			return ResponseEntity.ok(course.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping()
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course createdCourse = classService.createCourse(course);
		return ResponseEntity.ok(createdCourse);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
		classService.deleteCourse(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse
			) {
		Course course = classService.updateCourse(id, updatedCourse);
		if (course != null) {
			return ResponseEntity.ok(course);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
