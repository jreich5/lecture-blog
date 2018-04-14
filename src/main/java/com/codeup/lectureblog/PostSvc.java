package com.codeup.lectureblog;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostSvc {

    List<Post> posts;

    public PostSvc() {
        this.posts = new ArrayList<>();
        populateList();
    }

    public Post find(long id) {
        return this.posts.get((int) id - 1);
    }

    public List<Post> findAll() {
        return this.posts;
    }

    private void populateList() {
        posts.add(new Post("Test Post 1", "This is a post about number 1"));
        posts.add(new Post("Test Post 2", "This is a post about number 2"));
        posts.add(new Post("Test Post 3", "This is a post about number 3"));
        posts.add(new Post("Test Post 4", "This is a post about number 4"));
    }

}
