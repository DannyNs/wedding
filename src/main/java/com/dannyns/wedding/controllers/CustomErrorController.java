package com.dannyns.wedding.controllers;

import com.dannyns.wedding.services.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @Autowired
    private ErrorService errorService;

    @RequestMapping(value=ERROR_PATH, method= RequestMethod.GET)
    public String renderErrorPage(final Model model, final HttpServletRequest request){

        final int error_code=getHttpStatusCode(request);

        final String error_message=errorService.generateErrorMessage(error_code);

        model.addAttribute("errorMsg",error_message);
        model.addAttribute("page", "error");

        return "layouts/index";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    private int getHttpStatusCode(final HttpServletRequest request){
        return (int) request.getAttribute("javax.servlet.error.status_code");
    }
}
