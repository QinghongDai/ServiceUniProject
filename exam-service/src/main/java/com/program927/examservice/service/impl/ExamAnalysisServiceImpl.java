package com.program927.examservice.service.impl;

import com.program927.examservice.dao.ExamAnalysisDao;
import com.program927.examservice.model.examAnalysis.ExamAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.program927.examservice.service.ExamAnalysisService;

import java.util.List;

@Service
public class ExamAnalysisServiceImpl implements ExamAnalysisService {
    @Autowired
    private ExamAnalysisDao examAnalysisDao;

    @Override
    public List<ExamAnalysis> getTopPopularExams() {
        return examAnalysisDao.getTopPopularExams();
    }

    @Override
    public List<ExamAnalysis> getTopFailRatesExams() {
        return examAnalysisDao.getTopFailRatesExams();
    }
}
