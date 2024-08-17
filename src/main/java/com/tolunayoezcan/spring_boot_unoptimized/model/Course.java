package com.tolunayoezcan.spring_boot_unoptimized.model;

import com.tolunayoezcan.spring_boot_unoptimized.enums.CourseTypeEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "COURSE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "semester_hours")
    private double semesterHours;

    @Column(name = "course_type")
    private CourseTypeEnum courseType;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id")
    private Lecturer lecturer;

}
