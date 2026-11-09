  package psu.se411.lab14Practice.controller;

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

import psu.se411.lab14Practice.model.Course;
import psu.se411.lab14Practice.service.CourseService;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
	
	private CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	
	@GetMapping()
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> courses = courseService.getAllCourses();
		return ResponseEntity.ok(courses);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Optional<Course> course = courseService.getCourseById(id);
		if (course.isPresent()) {
			return ResponseEntity.ok(course.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//this is me trying to update the course by id
	@PutMapping("/{id}/update")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
	    try {
	    		        Course course = courseService.updateCourse(id, updatedCourse);
	        return ResponseEntity.ok(course);
	    } catch (RuntimeException e) {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping("/create")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
			    Course createdCourse = courseService.createCourse(course);
	    return ResponseEntity.ok(createdCourse);
	}
	 
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
			    courseService.deleteCourse(id);
	    return ResponseEntity.noContent().build();
	}

}
