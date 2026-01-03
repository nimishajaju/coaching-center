package com.project.coaching.center.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDTO {
    private String  courseName;
    private String description;
    private Integer durationInMonths;
}
