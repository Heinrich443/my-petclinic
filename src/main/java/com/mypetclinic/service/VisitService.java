package com.mypetclinic.service;

import com.mypetclinic.model.Visit;

import java.util.Set;

public interface VisitService {

    Set<Visit> getVisits(Integer petId);

    Boolean saveVisit(Visit visit);
}
