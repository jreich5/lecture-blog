package com.codeup.lectureblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringTransformController {

    @GetMapping("/string/reverse/{input}")
    @ResponseBody
    public String reverseString(@PathVariable String input) {
        return new StringBuilder(input).reverse().toString();
    }

    @GetMapping("/string/caps/{input}")
    @ResponseBody
    public String capString(@PathVariable String input) {
        return input.toUpperCase();
    }

    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String capAndReverseString(@PathVariable String string) {
        return reverseString(capString(string));
    }

}
