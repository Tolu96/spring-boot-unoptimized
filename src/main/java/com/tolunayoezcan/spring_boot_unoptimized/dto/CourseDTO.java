package com.tolunayoezcan.spring_boot_unoptimized.dto;

import com.tolunayoezcan.spring_boot_unoptimized.enums.CourseTypeEnum;
import lombok.Data;

@Data
public class CourseDTO {
    int courseId;
    String courseName;
    double semesterHours;
    CourseTypeEnum courseType;
    LecturerDTO lecturer;
}
