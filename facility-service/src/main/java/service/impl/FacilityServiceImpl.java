package service.impl;

import dao.FacilityDao;
import lombok.extern.log4j.Log4j;
import model.common.MessageResponse;
import model.facility.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.FacilityService;

import java.util.List;
@Service
@Log4j
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
