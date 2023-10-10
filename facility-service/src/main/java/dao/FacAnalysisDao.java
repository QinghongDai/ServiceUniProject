package dao;

import model.facAnalysis.FacAnalysis;

import java.util.List;

public interface FacAnalysisDao {
    List<FacAnalysis> getTopPopularFacilities();

    List<FacAnalysis> getTopRatesFacilities();
}
