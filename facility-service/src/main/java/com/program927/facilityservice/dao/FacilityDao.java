package com.program927.facilityservice.dao;


import com.program927.facilityservice.model.facility.Facility;

import java.util.List;

public interface FacilityDao {

    List<Facility> findAll();

    Facility findById(Integer id);

    int save(Facility facility);

    int update(Integer id, Facility facility);

    int deleteById(Integer id);
}
