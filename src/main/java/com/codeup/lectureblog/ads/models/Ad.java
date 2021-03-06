package com.codeup.lectureblog.ads.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="ads")
public class Ad {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Ads must have a title")
    @Size(min = 3, message = "A title must be at least 3 characters.")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Ads must have a description")
    private String description;

    // one Ad has one set of details
    @OneToOne
    @JoinColumn(name="details_id")
    private AdDetails adDetails;

    // one Ad has many images
    @OneToMany(cascade=ALL, mappedBy="ad")
    @JsonBackReference
    private List<AdImage> images;

    // many Ads belong have many categories
    @ManyToMany
    @JoinTable(name="ads_categories",
            joinColumns={@JoinColumn(name="ad_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")})
    @JsonManagedReference
    private List<AdCategory> categories;

    // one Ad has many comments
    @OneToMany(cascade=ALL, mappedBy="ad")
    @JsonBackReference
    private List<AdComment> comments;

    // many ads belong to one User
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonManagedReference
    private AdUser user;

    public Ad() {}

    public Ad(String title, String description, AdDetails adDetails, List<AdImage> images, List<AdCategory> categories, List<AdComment> comments, AdUser user) {
        this.title = title;
        this.description = description;
        this.adDetails = adDetails;
        this.images = images;
        this.categories = categories;
        this.comments = comments;
        this.user = user;
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

    public AdDetails getAdDetails() {
        return adDetails;
    }

    public void setAdDetails(AdDetails adDetails) {
        this.adDetails = adDetails;
    }

    public List<AdImage> getImages() {
        return images;
    }

    public void setImages(List<AdImage> images) {
        this.images = images;
    }

    public List<AdCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<AdCategory> categories) {
        this.categories = categories;
    }

    public List<AdComment> getComments() {
        return comments;
    }

    public void setComments(List<AdComment> comments) {
        this.comments = comments;
    }

    public AdUser getUser() {
        return user;
    }

    public void setUser(AdUser user) {
        this.user = user;
    }
}
