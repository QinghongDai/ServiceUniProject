package com.program927.facilityservice.service;

import com.program927.facilityservice.model.common.MessageResponse;
import com.program927.facilityservice.model.facility.Facility;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FacilityService {

    List<Facility> getAllFacilities();

    Facility getFacilityById(Integer id);

    MessageResponse createFacility(Facility facility);

    MessageResponse updateFacility(Integer id, Facility facility);

    MessageResponse deleteFacility(Integer id);
}
