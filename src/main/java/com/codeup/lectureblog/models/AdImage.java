package com.codeup.lectureblog.models;


import javax.persistence.*;

@Entity
@Table(name="images")
public class AdImage {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String path;

    // many Images belong to one Ad
    @ManyToOne
    @JoinColumn(name="ad_id")
    private Ad ad;

    public AdImage() {
    }

    public AdImage(String path, Ad ad) {
        this.path = path;
        this.ad = ad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}
