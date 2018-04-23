package com.codeup.lectureblog.ads.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class AdComment {

    @Id
    @GeneratedValue
    private long id;

    private String body;

    // many Comments belong to one User
    @ManyToOne
    @JoinColumn(name="user_id")
    private AdUser user;

    // many Comments belong to one Ad
    @ManyToOne
    @JoinColumn(name="ad_id")
    @JsonManagedReference
    private Ad ad;

    public AdComment() {
    }

    public AdComment(String body, AdUser user, Ad ad) {
        this.body = body;
        this.user = user;
        this.ad = ad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AdUser getUser() {
        return user;
    }

    public void setUser(AdUser user) {
        this.user = user;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
