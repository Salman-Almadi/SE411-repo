package psu.se411.lab14Practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import psu.se411.lab14Practice.model.Course;
import psu.se411.lab14Practice.repository.CourseRepo;

 @Service
public class CourseService {

	private CourseRepo courseRepo;
	
	public CourseService(CourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	public List<Course> getAllCourses() {
		return (List<Course>) courseRepo.findAll();
	}
	
	public Optional<Course> getCourseById(Long id) {
		return courseRepo.findById(id);
	}
	
	
	//this is me trying to update the course by id
	public Course updateCourse(Long id, Course updatedCourse) {
	    Optional<Course> existingCourseOptional = courseRepo.findById(id);
	    if (existingCourseOptional.isPresent()) {
	        Course existingCourse = existingCourseOptional.get();
	        Course newCourse = new Course(
	            existingCourse.id(),
	            updatedCourse.Code(),
	            updatedCourse.Name(),
	            updatedCourse.Description(),
	            updatedCourse.Credits()
	        );
	        return courseRepo.save(newCourse);
	    } else {
	        throw new RuntimeException("Course not found with id: " + id);
	    }
	}
	
	public Course createCourse(Course course) {
		return courseRepo.save(course);
	}
	
	public void deleteCourse(Long id) {
		courseRepo.deleteById(id);
	}
}
