package com.codeup.lectureblog.models;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class AdCategory {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String name;

}
