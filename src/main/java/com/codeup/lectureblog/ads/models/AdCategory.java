package com.codeup.lectureblog.ads.models;

import com.codeup.lectureblog.ads.models.Ad;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
public class AdCategory {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String name;

    // many Categories belong to many Ads
    @ManyToMany(mappedBy="categories")
    @JsonBackReference
    private List<Ad> ads;

    public AdCategory() {}

    public AdCategory(String name, List<Ad> ads) {
        this.name = name;
        this.ads = ads;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }
}
