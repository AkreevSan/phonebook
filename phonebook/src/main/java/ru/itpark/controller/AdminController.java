package ru.itpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.model.Person;
import ru.itpark.service.AuthorizationService;
import ru.itpark.service.PersonService;

@Controller
public class AdminController {

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



    @RequestMapping(value = "/delete/{login}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("login") String login, Model model) {

        this.authorizationService.delete(login);
        model.addAttribute("author", new Person());
        model.addAttribute("authorizations", this.authorizationService.getAll());
        model.addAttribute("person", new Person());
        model.addAttribute("listPerson", this.personService.listPerson());
        return "adminpage";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser1(@RequestParam("group1") String login,  Model model) {

        this.authorizationService.delete(login);
        model.addAttribute("author", new Person());
        model.addAttribute("authorizations", this.authorizationService.getAll());
        model.addAttribute("person", new Person());
        model.addAttribute("listPerson", this.personService.listPerson());
        return "adminpage";
    }

}
