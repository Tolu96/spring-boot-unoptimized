package com.tolunayoezcan.spring_boot_unoptimized.repository;

import com.tolunayoezcan.spring_boot_unoptimized.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
}
