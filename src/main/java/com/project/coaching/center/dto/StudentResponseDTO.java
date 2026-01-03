package com.project.coaching.center.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {
    private Long studentId;
    private String studentName;
    private String email;
    private Long courseId;
}
