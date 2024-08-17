package com.tolunayoezcan.spring_boot_unoptimized.mapper;

import com.tolunayoezcan.spring_boot_unoptimized.dto.CourseDTO;
import com.tolunayoezcan.spring_boot_unoptimized.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO modelToDto(Course course);

    List<CourseDTO> modelsToDto(List<Course> courses);

    Course dtoToModel(CourseDTO courseDTO);
}
