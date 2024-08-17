package com.tolunayoezcan.spring_boot_unoptimized.dto;

import lombok.Data;

@Data
public class LecturerDTO {
    int lecturerId;
    String firstName;
    String lastName;
    int personnelNumber;
    String email;
    String room;
    boolean isDean;
    DegreeProgramDTO degreeProgram;
}
