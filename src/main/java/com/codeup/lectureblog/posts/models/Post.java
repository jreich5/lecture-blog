package com.codeup.lectureblog.posts.models;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    @NotBlank(message="Title cannot be blank.")
    @Size(max=10, message="Title cannot be longer than 10 characters.")
    private String title;

    @Column(nullable=false)
    @Size(min=10, message="Body must be at least 10 characters long.")
    private String body;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    public Post() {
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
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
}
