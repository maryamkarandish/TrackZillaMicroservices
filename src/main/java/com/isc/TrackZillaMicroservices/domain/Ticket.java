package com.isc.TrackZillaMicroservices.domain;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticket_id")
    private Integer id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false, name = "description")
    private String description;

    @Column(nullable = false)
    private Integer applicationId;

    @Column(nullable = false)
    private Integer person_id;

    public Ticket() {
    }

    public Ticket(String title, String description, Integer application_id, Integer person_id) {
        this.title = title;
        this.description = description;
        this.applicationId = application_id;
        this.person_id = person_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer application_id) {
        this.applicationId = application_id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }


}
