package com.isc.TrackZillaMicroservices.service;

import com.isc.TrackZillaMicroservices.domain.Application;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ApplicationService {
    List<Application> listApplications();
}

