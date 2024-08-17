package com.tolunayoezcan.spring_boot_unoptimized.repository;

import com.tolunayoezcan.spring_boot_unoptimized.enums.CampusEnum;
import com.tolunayoezcan.spring_boot_unoptimized.model.DegreeProgram;
import com.tolunayoezcan.spring_boot_unoptimized.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DegreeProgramRepository extends JpaRepository<DegreeProgram, Integer> {

}
