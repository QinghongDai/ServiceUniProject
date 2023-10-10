package service;

import model.common.MessageResponse;
import model.facAppointment.FacAppointment;
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
