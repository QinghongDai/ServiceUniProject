package dao;

import model.facAppointment.FacAppointment;

import java.util.List;

public interface FacAppointmentDao {

    List<FacAppointment> findAll();

    FacAppointment findById(Integer id);

    int save(FacAppointment facAppointment);

    int update(Integer id, FacAppointment facAppointment);

    int deleteById(Integer id);
}
