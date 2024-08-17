package com.tolunayoezcan.spring_boot_unoptimized.dto;

import com.tolunayoezcan.spring_boot_unoptimized.enums.CampusEnum;
import lombok.Data;

@Data
public class DegreeProgramDTO {
    int degreeProgramId;
    String name;
    String abbreviation;
    short ectsPoints;
    CampusEnum campus;
    byte numberOfSemester;
    FacultyDTO faculty;
}
