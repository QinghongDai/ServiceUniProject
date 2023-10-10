package com.program927.examservice.service;

import com.program927.examservice.model.examAnalysis.ExamAnalysis;

import java.util.List;

public interface ExamAnalysisService {

    List<ExamAnalysis> getTopPopularExams();

    List<ExamAnalysis> getTopFailRatesExams();
}
