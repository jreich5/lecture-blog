package com.codeup.lectureblog.controllers;

import com.codeup.lectureblog.models.Ad;
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