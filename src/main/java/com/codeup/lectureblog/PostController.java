package com.codeup.lectureblog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("A Post 1", "Some amount of post info...1"));
        posts.add(new Post("A Post 2", "Some amount of post info...2"));
        posts.add(new Post("A Post 3", "Some amount of post info...3"));
        posts.add(new Post("A Post 4", "Some amount of post info...4"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post post = new Post("A Post", "Here is a Post");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "Here is the form to create posts!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert() {
        return "Post inserted!";
    }


}
