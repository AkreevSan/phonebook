package ru.itpark.controller;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.model.Authorization;
import ru.itpark.model.Person;
import ru.itpark.service.AuthorizationService;
import ru.itpark.service.PersonService;


@Controller
public class AuthorizationController {


    private AuthorizationService authorizationService;

    @Autowired(required = true)
    @Qualifier(value = "authorizationService")
    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    private PersonService personService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }


    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    private String enterPost(@RequestParam("button") String button, @RequestParam("log") String log,
                             @RequestParam("pass") String pass, Model model) {

        if ("signin".equals(button)) {
            if (log.indexOf(".") != -1) {
                log = log.substring(0, log.indexOf(".")) + log.substring(log.indexOf(".") + 1, log.length());
            }

            Authorization user = authorizationService.get(log);
            String md5Hex = DigestUtils.md5Hex(pass);
            if (user != null && user.getPassword().equals(md5Hex)) {


                if ("admin".equals(user.getRole())) {
                    model.addAttribute("author", new Authorization());
                    model.addAttribute("authorizations", this.authorizationService.getAll());
                    model.addAttribute("person", new Person());
                    model.addAttribute("listPerson", this.personService.listPerson());

                    return "adminpage";
                } else {
                    model.addAttribute("person", new Person());
                    model.addAttribute("listPerson", this.personService.listPerson());
                    return "userpage";
                }

            } else {
                model.addAttribute("fail", "Authorization failed! Please check your login and password.");
                return "welcome";
            }


        } else if ("registration".equals(button)) {

            return "registration";
        } else {
            model.addAttribute("person", new Person());
            model.addAttribute("listPerson", this.personService.listPerson());
            return "anonymouspage";

        }


    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    private String enterPost(){
        return "welcome";
    }
}
