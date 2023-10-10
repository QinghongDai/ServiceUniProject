package service.impl;

import dao.FacAppointmentDao;
import lombok.extern.log4j.Log4j;
import model.common.MessageResponse;
import model.facAppointment.FacAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.FacAppointmentService;

import java.util.List;

@Service
@Log4j
public class FacAppointmentServiceImpl implements FacAppointmentService {
    @Autowired
    private FacAppointmentDao facAppointmentDao;

    @Override
    public List<FacAppointment> getAllFacAppointment() {
        return facAppointmentDao.findAll();
    }
    @Override
    public FacAppointment getFacAppointmentById(Integer id) {
        return facAppointmentDao.findById(id);
    }

    @Override
    public MessageResponse createFacAppointment(FacAppointment facAppointment) {
        int result = facAppointmentDao.save(facAppointment);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }

    @Override
    public MessageResponse updateFacAppointment(Integer id, FacAppointment facAppointmentParam){
        FacAppointment facAppointment = facAppointmentDao.findById(id);
        if (null== facAppointment){
            return MessageResponse.builder().message("Fail").build();
        } else {
            int result = facAppointmentDao.update(id, facAppointmentParam);
            if (0 == result){
                return MessageResponse.builder().message("Fail").build();
            }
            return MessageResponse.builder().message("Success").build();
        }
    }

    @Override
    public MessageResponse deleteFacAppointment(Integer id) {
        int result = facAppointmentDao.deleteById(id);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }
}
