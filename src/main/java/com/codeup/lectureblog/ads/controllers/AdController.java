package com.codeup.lectureblog.ads.controllers;

import com.codeup.lectureblog.ads.models.Ad;
import com.codeup.lectureblog.ads.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {


    // ======================= version WITHOUT form model binding
//    @GetMapping("/ads/create")
//    public String showCreateForm() {
//        return "ads/create_ad";
//    }
//
//
//    @PostMapping("/ads/create")
//    @ResponseBody
//    public String create(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "description") String description
//    ) {
//        Ad ad = new Ad();
//        ad.setTitle(title);
//        ad.setDescription(description);
//        // save the ad...
//        return "Ad saved!";
//    }


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


    // ======================= version WITH form model binding

    @GetMapping("/ads/create")
    public String showCreateForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "ads/create_ad";
    }

    @PostMapping("/ads/create")
    @ResponseBody
    public String create(@ModelAttribute Ad ad) {
        System.out.println(ad.getTitle());
        System.out.println(ad.getDescription());
        return "Ad saved!";
    }
}