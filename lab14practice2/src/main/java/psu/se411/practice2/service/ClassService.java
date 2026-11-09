package psu.se411.practice2.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import psu.se411.practice2.model.Course;
import psu.se411.practice2.repository.ClassRepository;

@Service
public class ClassService{ 
	private final ClassRepository classRepository;
	
	public ClassService(ClassRepository classRepository) {
		this.classRepository = classRepository;
	}
	
	public Iterable<Course> getAllCourses() {
		return classRepository.findAll();
		}
	
	public Optional<Course> getCourseById(Long id) {
		return classRepository.findById(id);			
	}
	
	public Course createCourse(Course course) {
		return classRepository.save(course);
	}
	
	public void deleteCourse(Long id) {
		classRepository.deleteById(id);
	}
	
	public Course updateCourse(Long id, Course updatedCourse) {
	    Optional<Course> existingCourseOptional = classRepository.findById(id);
	    if (existingCourseOptional.isPresent()) {
	        Course existingCourse = existingCourseOptional.get();
	        Course newCourse = new Course(
	            existingCourse.id(),
	            updatedCourse.Code(),
	            updatedCourse.Name(),
	            updatedCourse.Description(),
	            updatedCourse.Credits()
	        );
	        return classRepository.save(newCourse);
	    } else {
	        throw new RuntimeException("Course not found with id: " + id);
	    }
	}
}
