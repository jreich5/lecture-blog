package com.codeup.lectureblog.posts.controllers;


import com.codeup.lectureblog.posts.models.Post;
import com.codeup.lectureblog.posts.models.User;
import com.codeup.lectureblog.posts.services.PostSvc;
import com.codeup.lectureblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PostController {

    private UserRepository userDao;
    private PostSvc postSvc;

    public PostController(PostSvc postSvc, UserRepository userDao) {
        this.postSvc = postSvc;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@Valid Post post, Errors validation, Model model) {

        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", post);
            return "/posts/create";
        } else {
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            post.setUser(loggedInUser);
            postSvc.save(post);
            return "redirect:/posts";
        }
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@PathVariable long id, @ModelAttribute Post post) {
        Post originalPost = postSvc.findOne(id);
        originalPost.setTitle(post.getTitle());
        originalPost.setBody(post.getBody());
        postSvc.save(originalPost);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postSvc.delete(id);
        return "redirect:/posts";
    }

}
