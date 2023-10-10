package model.examParticipants;

import lombok.Data;

@Data
public class ExamParticipants {
    private Integer id;
    private Integer examId;
    private Integer userId;
    private double score;
    //0 complete 1 waiting for exam
    private String status;
}
