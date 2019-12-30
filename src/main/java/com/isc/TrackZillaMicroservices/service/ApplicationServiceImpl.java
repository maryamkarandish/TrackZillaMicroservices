package com.isc.TrackZillaMicroservices.service;

import com.isc.TrackZillaMicroservices.domain.Application;
import com.isc.TrackZillaMicroservices.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> listApplications() {
        return applicationRepository.findAll();
    }

}
