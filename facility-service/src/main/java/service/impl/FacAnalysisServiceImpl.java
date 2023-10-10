package service.impl;

import dao.FacAnalysisDao;
import lombok.extern.log4j.Log4j;
import model.facAnalysis.FacAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.FacAnalysisService;

import java.util.List;

@Service
@Log4j
public class FacAnalysisServiceImpl implements FacAnalysisService {
    @Autowired
    private FacAnalysisDao facAnalysisDao;

    @Override
    public List<FacAnalysis> getTopPopularFacilities() {
        return facAnalysisDao.getTopPopularFacilities();
    }

    @Override
    public List<FacAnalysis> getTopRatesFacilities() {
        return facAnalysisDao.getTopRatesFacilities();
    }
}
