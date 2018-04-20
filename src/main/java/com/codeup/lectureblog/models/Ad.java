package com.codeup.lectureblog.models;

import javax.persistence.*;

@Entity
@Table(name="ads")
public class Ad {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name="details_id")
    private AdDetails adDetails;

    public Ad() {
    }


    public Ad(String title, String description, AdDetails adDetails) {
        this.title = title;
        this.description = description;
        this.adDetails = adDetails;
    }

    public Ad(long id, String title, String description, AdDetails adDetails) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.adDetails = adDetails;
    }

    public AdDetails getAdDetails() {
        return adDetails;
    }

    public void setAdDetails(AdDetails adDetails) {
        this.adDetails = adDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
