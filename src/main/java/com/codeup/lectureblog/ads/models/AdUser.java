package com.codeup.lectureblog.ads.models;


import com.codeup.lectureblog.ads.models.Ad;
import com.codeup.lectureblog.ads.models.AdComment;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ad_users")
public class AdUser {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false, unique=true)
    private String username;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false, unique=true)
    private String password;

    // one User has many Ads
    @OneToMany(mappedBy="user")
    @JsonBackReference
    private List<Ad> ads;

    // one User has
    @OneToMany(mappedBy="user")
    private List<AdComment> comments;

    public AdUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public List<AdComment> getComments() {
        return comments;
    }

    public void setComments(List<AdComment> comments) {
        this.comments = comments;
    }
}
