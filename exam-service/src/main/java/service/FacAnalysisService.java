package service;

import model.facAnalysis.FacAnalysis;

import java.util.List;

public interface FacAnalysisService {

    List<FacAnalysis> getTopPopularFacilities();

    List<FacAnalysis> getTopRatesFacilities();
}
