package com.codeup.lectureblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

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

}
