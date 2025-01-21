package wedding.invitation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wedding.invitation.configuration.I18nConfig;

import java.util.Locale;


@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    I18nConfig i18nConfig;

    @GetMapping("/")
    public String getUser(Locale locale){
        return i18nConfig.messageSource("welcome.message");
    }
}
