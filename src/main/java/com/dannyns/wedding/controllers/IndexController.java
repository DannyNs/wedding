package com.dannyns.wedding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        return index(model, "index");
    }

    @RequestMapping("/{page}.html")
    public String index(Model model, @PathVariable String page) {
        model.addAttribute("page", page);

        return "layouts/index";
    }

}
