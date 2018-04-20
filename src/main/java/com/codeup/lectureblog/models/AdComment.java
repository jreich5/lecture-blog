package com.codeup.lectureblog.models;


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
    private User user;

    // many Comments belong to one Ad
    @ManyToOne
    @JoinColumn(name="ad_id")
    private Ad ad;

    public AdComment() {
    }

    public AdComment(String body, User user, Ad ad) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
