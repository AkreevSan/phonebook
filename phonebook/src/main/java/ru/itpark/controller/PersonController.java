package ru.itpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.model.Person;
import ru.itpark.service.PersonService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ilsiya on 23.11.2016.
 */
@Controller
public class PersonController {
    private PersonService personService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }


    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person, Model model) {
        if (person.getId() == 0) {
            this.personService.addPerson(person);
        } else {
            this.personService.updatePerson(person);
        }
        model.addAttribute("person", new Person());
        model.addAttribute("listPerson", this.personService.listPerson());
        return "persons";
    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id, Model model) {

        this.personService.removePerson(id);
        model.addAttribute("person", new Person());
        model.addAttribute("listPerson", this.personService.listPerson());
        return "persons";
    }

    @RequestMapping("edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPerson", this.personService.listPerson());

        return "persons";
    }

    @RequestMapping("persondata/{id}")
    public String personData(@PathVariable("id") int id, Model model) {

        model.addAttribute("person", this.personService.getPersonById(id));

        return "persondata";
    }

}
