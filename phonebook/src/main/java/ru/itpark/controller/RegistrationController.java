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
import ru.itpark.service.AuthorizationService;

/**
 * Created by Акреев on 25.11.2016.
 */
@Controller
public class RegistrationController {

    private AuthorizationService authorizationService;

    @Autowired(required = true)
    @Qualifier(value = "authorizationService")
    public void setPersonService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @RequestMapping(value = "/registration.form", method = RequestMethod.POST)
    private String register(@RequestParam("log") String log, @RequestParam("pass") String pass,
                            @RequestParam("pass2") String pass2, Model model) {
        if ((!"".equals(log)) && (pass.equals(pass2)) && (!"".equals(pass))) {


            Authorization authorization = new Authorization();

            if (log.indexOf(".") != -1) {
                log = log.substring(0, log.indexOf(".")) + log.substring(log.indexOf(".") + 1, log.length());
            }

            Authorization user = authorizationService.get(log);
            if (user != null) {
                model.addAttribute("fail", "Registration failed! Login already exists!");

                return "welcome";
            }


            authorization.setLogin(log);

            String md5Hex = DigestUtils.md5Hex(pass);

            authorization.setPassword(md5Hex);
            authorization.setRole("user");


            this.authorizationService.add(authorization);
            model.addAttribute("info", "Registration is successful!");

            return "welcome";
        }else {
            model.addAttribute("fail", "Registration failed! Invalid login or password!");
            return "welcome";
        }
    }
}
