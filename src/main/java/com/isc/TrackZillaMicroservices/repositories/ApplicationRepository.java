package com.isc.TrackZillaMicroservices.repositories;

import com.isc.TrackZillaMicroservices.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
