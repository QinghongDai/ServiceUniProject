package com.program927.facilityservice.dao;

import com.program927.facilityservice.model.facAnalysis.FacAnalysis;

import java.util.List;

public interface FacAnalysisDao {
    List<FacAnalysis> getTopPopularFacilities();

    List<FacAnalysis> getTopRatesFacilities();
}
