package psu.se411.lab14Practice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import psu.se411.lab14Practice.model.Course;


@Repository
public interface CourseRepo extends CrudRepository<Course, Long> , PagingAndSortingRepository<Course, Long> {

}
