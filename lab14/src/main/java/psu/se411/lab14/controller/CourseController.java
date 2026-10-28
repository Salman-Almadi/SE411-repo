package psu.se411.lab14.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import psu.se411.lab14.model.Course;
import psu.se411.lab14.repository.CourseRepository;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    // GET /api/v1/courses
    @GetMapping
    public Iterable<Course> getAllCourses() {
        return repository.findAll();
    }

    // GET /api/v1/courses/1
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable("id") Long id) {
        return ResponseEntity.of(repository.findById(id));
    }

    // POST /api/v1/courses
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {

        // New courses receive an automatically generated ID.
        if (course.id() != null) {
            if (repository.existsById(course.id())) {
                return ResponseEntity.status(422).build();
            }

            return ResponseEntity.badRequest().build();
        }

        Course savedCourse = repository.save(course);

        URI location = URI.create("/api/v1/courses/" + savedCourse.id());

        return ResponseEntity.created(location).body(savedCourse);
    }

    // PUT /api/v1/courses/1
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(
            @PathVariable("id") Long id,
            @RequestBody Course course) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Course updatedCourse = new Course(
            id,
            course.code(),
            course.name(),
            course.description(),
            course.credits()
        );

        repository.save(updatedCourse);

        return ResponseEntity.noContent().build();
    }

    // DELETE /api/v1/courses/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}