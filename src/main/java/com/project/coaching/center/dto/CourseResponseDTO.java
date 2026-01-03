package com.project.coaching.center.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {
    private Long courseId;
    private String  courseName;
    private String description;
    private Integer durationInMonths;
}
