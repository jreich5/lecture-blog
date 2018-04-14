package com.codeup.lectureblog.controllers;

import com.codeup.lectureblog.services.StringTransformSvc;
import com.codeup.lectureblog.services.PigLatinSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    public PigLatinSvc pigLatinSvc;
    public StringTransformSvc stringTransformSvc;

    public HomeController(PigLatinSvc pigLatinSvc, StringTransformSvc stringTransformSvc) {
        this.pigLatinSvc = pigLatinSvc;
        this.stringTransformSvc = stringTransformSvc;
    }

    @GetMapping("/")
    @ResponseBody
    public String returnLandingMessage() {
        return "This is the landing page!";
    }

    // returning a view
    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

    // returning a view with context variables
    @GetMapping("/hi/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "home";

    }

    // if and each tags
    @GetMapping("/all/{willSayHi}")
    public String allHello(@PathVariable boolean willSayHi, Model model) {

        List<String> names = new ArrayList<>();

        names.add("Fred");
        names.add("John");
        names.add("Lisa");

        model.addAttribute("names", names);
        model.addAttribute("willSayHi", willSayHi);

        return "home";

    }

    @GetMapping("/roll-dice")
    public String showDiceForm() {
        return "roll-dice-form";
    }

    @GetMapping("/roll-dice/{num}")
    public String showResult(@PathVariable int num, Model model) {
        Random rand = new Random();
        int n = rand.nextInt(6) + 1;
        model.addAttribute("number", n);
        model.addAttribute("guess", num);

        return "dice-outcome";
    }

    @GetMapping("/pig")
    public String getPigTranslateForm() {
        return "pig";
    }

    @PostMapping("/pig")
    @ResponseBody
    public String getTranslation(@RequestParam("phrase") String phrase){
        return pigLatinSvc.translate(phrase);
    }

}
