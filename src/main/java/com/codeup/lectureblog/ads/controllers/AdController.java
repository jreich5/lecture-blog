package com.codeup.lectureblog.ads.controllers;

import com.codeup.lectureblog.ads.models.Ad;
import com.codeup.lectureblog.ads.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AdController {

    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/create")
    public String showCreateForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "ads/create_ad";
    }

    @PostMapping("/ads/create")
    public String create(@Valid Ad ad, Errors errors, Model model) {

        // custom validation
        if (ad.getTitle().contains("zed")) {
            errors.rejectValue("title", "zed-error", "Cannot include 'zed'!");
        }

        if (errors.hasErrors()) {
            model.addAttribute(ad);
            return "ads/create_ad";
        }

        adDao.save(ad);
        return "redirect:/ads";
    }
}