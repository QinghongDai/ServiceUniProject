package com.program927.facilityservice.service;

import com.program927.facilityservice.model.common.MessageResponse;
import com.program927.facilityservice.model.facAppointment.FacAppointment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FacAppointmentService {


    List<FacAppointment> getAllFacAppointment();

    FacAppointment getFacAppointmentById(Integer id);

    MessageResponse createFacAppointment(FacAppointment facAppointment);

    MessageResponse updateFacAppointment(Integer id, FacAppointment facAppointment);

    MessageResponse deleteFacAppointment(Integer id);
}
