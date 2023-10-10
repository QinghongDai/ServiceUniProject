package com.program927.examservice.model.exam;

import lombok.Data;

@Data
public class Exam {
    private Integer id;
    private String type;
    private String subjectName;
    private String location;
    private String startTime;
    private Integer takeMins;
}
