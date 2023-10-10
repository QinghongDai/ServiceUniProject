package com.program927.examservice.dao;

import com.program927.examservice.model.examAnalysis.ExamAnalysis;

import java.util.List;

public interface ExamAnalysisDao {
    List<ExamAnalysis> getTopPopularExams();

    List<ExamAnalysis> getTopFailRatesExams();
}
