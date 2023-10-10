package com.program927.facilityservice.service;

import com.program927.facilityservice.model.facAnalysis.FacAnalysis;

import java.util.List;

public interface FacAnalysisService {

    List<FacAnalysis> getTopPopularFacilities();

    List<FacAnalysis> getTopRatesFacilities();
}
