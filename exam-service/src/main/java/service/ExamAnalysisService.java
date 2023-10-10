package service;

import model.examAnalysis.ExamAnalysis;

import java.util.List;

public interface ExamAnalysisService {

    List<ExamAnalysis> getTopPopularExams();

    List<ExamAnalysis> getTopFailRatesExams();
}
