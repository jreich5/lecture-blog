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

}
