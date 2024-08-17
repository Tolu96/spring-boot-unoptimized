package com.tolunayoezcan.spring_boot_unoptimized.repository;

import com.tolunayoezcan.spring_boot_unoptimized.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
