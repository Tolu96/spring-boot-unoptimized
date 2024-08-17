package com.tolunayoezcan.spring_boot_unoptimized.dto;

import com.tolunayoezcan.spring_boot_unoptimized.enums.AnnotationEnum;
import com.tolunayoezcan.spring_boot_unoptimized.enums.StatusEnum;
import lombok.Data;

import java.util.UUID;

@Data
public class ExamDTO {
    UUID examId;
    StudentDTO student;
    CourseDTO course;
    byte attempt;
    StatusEnum status;
    double grade;
    AnnotationEnum annotation;
}
