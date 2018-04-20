package com.codeup.lectureblog.posts.controllers;


import com.codeup.lectureblog.posts.models.Post;
import com.codeup.lectureblog.posts.services.PostSvc;
import com.codeup.lectureblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String insert(@ModelAttribute Post post) {
        post.setUser(userDao.findOne(1L));
        postSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postSvc.delete(id);
        return "redirect:/posts";
    }

}
