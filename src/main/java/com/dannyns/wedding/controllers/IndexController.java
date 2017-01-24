package com.dannyns.wedding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dannyns.wedding.dto.ContactFormData;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        return index(model, "index");
    }

    @RequestMapping(value = "/contact.html", method = RequestMethod.GET)
    public String contactGet(Model model) {
        model.addAttribute("contactFormData", new ContactFormData());

        return index(model, "contact");
    }

    @RequestMapping(value = "/contact.html", method = RequestMethod.POST)
    public String contactPost(ContactFormData contactFormData) {

        System.out.println(contactFormData);

        return "redirect:/contact.html";
    }

    @RequestMapping("/{page}.html")
    public String index(Model model, @PathVariable String page) {
        model.addAttribute("page", page);

        return "layouts/index";
    }
}
