package psu.se411.lab14.repository;

import org.springframework.data.repository.CrudRepository;
import psu.se411.lab14.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
}

