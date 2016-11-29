package ru.itpark.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class WelcomeController {

    @RequestMapping(value = {"/","/back"}, method = RequestMethod.GET)
    private String welcome(HttpServletRequest request) {

        return "welcome";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private String logout(HttpServletRequest request) {
        HttpSession session=request.getSession();
        session.invalidate();

        return "welcome";
    }

}
