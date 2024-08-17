package com.tolunayoezcan.spring_boot_unoptimized.repository;

import com.tolunayoezcan.spring_boot_unoptimized.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
