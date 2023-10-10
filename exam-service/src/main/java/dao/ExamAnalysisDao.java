package dao;

import model.examAnalysis.ExamAnalysis;

import java.util.List;

public interface ExamAnalysisDao {
    List<ExamAnalysis> getTopPopularExams();

    List<ExamAnalysis> getTopFailRatesExams();
}
