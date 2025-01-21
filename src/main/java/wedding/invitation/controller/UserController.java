package wedding.invitation.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wedding.invitation.configuration.I18nConfig;
import wedding.invitation.dto.request.UserRequetDTO;
import wedding.invitation.dto.response.ResponseData;

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

    @PostMapping("/login")
    public ResponseData<?> login(@Valid @RequestBody UserRequetDTO user){
        return new ResponseData<>(200, i18nConfig.messageSource("user.login.success"));
    }
}
