package com.program927.examservice.model.examAnalysis;

import lombok.Data;

@Data
public class ExamAnalysis {
    private Integer examId;
    private Integer totalParticipants;
    private double failRates;
}
