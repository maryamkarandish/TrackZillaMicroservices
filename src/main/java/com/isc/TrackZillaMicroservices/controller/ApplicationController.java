package com.isc.TrackZillaMicroservices.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isc.TrackZillaMicroservices.domain.Application;
import com.isc.TrackZillaMicroservices.repositories.ApplicationRepository;
import com.isc.TrackZillaMicroservices.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


import java.io.IOException;
import java.util.List;
// this would call for usermanagement service to get additional details about a preson
@Controller
public class ApplicationController {
//    private ApplicationService applicationService;
    private ApplicationRepository applicationRepository;

//    @Autowired
//    public void setApplicationService(ApplicationService applicationService) {
//        this.applicationService = applicationService;
//    }

    @Autowired
    public void ApplicationController(final ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

//    public List<Application> getApplications() {
//        return applicationService.listApplications();
//    }

    @RequestMapping(path= "applications", method = RequestMethod.GET, produces = "application/hal+json")
    public @ResponseBody
    ResponseEntity<?> getApplications(){
        List<Application> applications = applicationRepository.findAll();

        applications.forEach(app -> getPersonInfo(app));

        Resources<Application> resources = new Resources<Application>(applications);
        resources.add(linkTo(methodOn(ApplicationController.class).getApplications()).withSelfRel());

        return ResponseEntity.ok(resources);

    }

    private void getPersonInfo(Application app) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String userManagementService = "http://localhost:8082/persons/" + app.getOwnerId();
            ResponseEntity<String> response = restTemplate.getForEntity(userManagementService, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = null;
            root = mapper.readTree(response.getBody());
            JsonNode name = root.path("name");
            JsonNode role = root.path("role");
            app.setOwnerName(name.asText());
            app.setOwnerRole(role.asText());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            app.setOwnerRole("Undefined");
            app.setOwnerName("Undefined");
            e.printStackTrace();
        }

    }


}
