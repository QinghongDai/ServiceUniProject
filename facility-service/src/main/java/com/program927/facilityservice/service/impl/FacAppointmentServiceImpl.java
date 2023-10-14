package com.program927.facilityservice.service.impl;

import com.program927.facilityservice.dao.FacAppointmentDao;
import com.program927.facilityservice.model.common.MessageResponse;
import com.program927.facilityservice.service.FacAppointmentService;
import com.program927.facilityservice.model.facAppointment.FacAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
