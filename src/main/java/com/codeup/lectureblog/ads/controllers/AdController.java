package com.codeup.lectureblog.ads.controllers;

import com.codeup.lectureblog.ads.models.Ad;
import com.codeup.lectureblog.ads.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdController {

    // JPA test
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
    public String create(@Valid Ad ad, Errors validation, Model model) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("ad", ad);
            return "ads/create_ad";
        } else {
            return "redirect:/ads";
        }
    }

    @GetMapping("/ads.json")
    @ResponseBody
    public Iterable<Ad> viewAllAdsInJSONFormat() {
        return adDao.findAll();
    }

    @GetMapping("/ads/ajax")
    public String viewAllAdsWithAjax() {
        return "ads/ajax";
    }

}