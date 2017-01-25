package com.dannyns.wedding.controllers;

import com.dannyns.wedding.dto.ContactFormData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import static java.util.Objects.nonNull;

@Controller
public class IndexController {

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/")
    public String index(Model model) {
        return index(model, "index");
    }

    @RequestMapping(value = "/contact.html", method = RequestMethod.GET)
    public String contactGet(Model model, @RequestParam(required = false) Boolean success) {
        model.addAttribute("contactFormData", new ContactFormData());

        if (nonNull(success)) {
            model.addAttribute("success", success);
            model.addAttribute("message", (success) ? "Wiadomość została wysłana" : "Wystąpił błąd podczas wysyłania wiadomości");
        }

        return index(model, "contact");
    }

    @RequestMapping(value = "/contact.html", method = RequestMethod.POST)
    public String contactPost(@Valid ContactFormData contactFormData, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            try {
                MimeMessage message = javaMailSender.createMimeMessage();

                MimeMessageHelper helper = new MimeMessageHelper(message);
                helper.setFrom("kasiaidaniel-28-10-2017@wp.pl");

                switch (contactFormData.getTarget()) {
                    case "kasia":
                        helper.addTo("kasiabaranska@wp.pl");
                        break;
                    case "daniel":
                        helper.addTo("danielkutyla@wp.pl");
                        break;
                    default:
                        helper.addTo("kasiabaranska@wp.pl");
                        helper.addTo("danielkutyla@wp.pl");
                        break;
                }

                helper.setText(contactFormData.getContent());
                helper.setReplyTo(contactFormData.getEmail());
                helper.setSubject("Wiadomość od " + contactFormData.getName() + " '" + contactFormData.getTopic() + "'");

                javaMailSender.send(message);

                return "redirect:/contact.html?success=true#contactForm";
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        return "redirect:/contact.html?success=false#contactForm";
    }

    @RequestMapping("/{page}.html")
    public String index(Model model, @PathVariable String page) {
        model.addAttribute("page", page);

        return "layouts/index";
    }
}
