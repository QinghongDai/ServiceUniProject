package service.impl;

import dao.ExamAnalysisDao;
import lombok.extern.log4j.Log4j;
import model.examAnalysis.ExamAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ExamAnalysisService;

import java.util.List;

@Service
@Log4j
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
