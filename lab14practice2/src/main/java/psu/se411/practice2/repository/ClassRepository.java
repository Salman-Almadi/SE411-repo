package psu.se411.practice2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import psu.se411.practice2.model.Course;

@Repository
public interface ClassRepository extends CrudRepository<Course, Long>, PagingAndSortingRepository<Course, Long> {

}
