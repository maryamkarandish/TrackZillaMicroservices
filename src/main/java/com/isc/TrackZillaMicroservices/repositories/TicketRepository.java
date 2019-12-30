package com.isc.TrackZillaMicroservices.repositories;

import com.isc.TrackZillaMicroservices.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(path = "bug")  //to change the url use this line
//@RepositoryRestResource(exported = false) // to hide the repository set the exported to false
// then we get the message Not Found
public interface TicketRepository extends JpaRepository<Ticket , Integer> {
//    @RestResource(path="descriptionIgnoreCaseContaining", rel="descriptionIgnoreCaseContaining")
//    public List<Ticket> findByDescriptionIgnoreCaseContainint(@Param("description") String description);

    @RestResource(path="findByApplicationId",rel="findByApplicationId")
    public List<Ticket> findByApplicationId(@Param("applicationId") Integer appId);

    @RestResource(path="titleIgnoreCaseContaining", rel="titleIgnoreCaseContaining")
    public List<Ticket> findByTitleIgnoreCaseContaining(@Param("title") String title);

//    void save(Ticket tick1);

    // List<Ticket> findByAppId(Integer id);
   // List<Ticket> findByAppId(String id);
   // List<Ticket> findAll();


}
