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

    private PostSvc postSvc;

    public PostController(PostSvc postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.find(id));
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
