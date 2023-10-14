package com.program927.facilityservice.service.impl;

import com.program927.facilityservice.model.facility.Facility;
import com.program927.facilityservice.dao.FacilityDao;
import com.program927.facilityservice.model.common.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.program927.facilityservice.service.FacilityService;

import java.util.List;
@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private FacilityDao facilityDao;
    @Override
    public List<Facility> getAllFacilities() {
        return facilityDao.findAll();
    }

    @Override
    public Facility getFacilityById(Integer id) {
        return facilityDao.findById(id);
    }

    @Override
    public MessageResponse createFacility(Facility facility) {
        int result = facilityDao.save(facility);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }

    @Override
    public MessageResponse updateFacility(Integer id, Facility facilityParam) {
        Facility facility = facilityDao.findById(id);
        if (null== facility){
            return MessageResponse.builder().message("Fail").build();
        } else {
            int result = facilityDao.update(id, facilityParam);
            if (0 == result){
                return MessageResponse.builder().message("Fail").build();
            }
            return MessageResponse.builder().message("Success").build();
        }
    }

    @Override
    public MessageResponse deleteFacility(Integer id) {
        int result = facilityDao.deleteById(id);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }
}
