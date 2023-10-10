package service;

import model.common.MessageResponse;
import model.facility.Facility;
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
