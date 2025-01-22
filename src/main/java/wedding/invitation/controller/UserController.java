package wedding.invitation.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wedding.invitation.configuration.I18nConfig;
import wedding.invitation.dto.request.UserRequestRegister;
import wedding.invitation.dto.request.UserRequetLogin;
import wedding.invitation.dto.response.ResponseData;
import wedding.invitation.service.Impservice.UserService;

import java.util.Locale;


@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    I18nConfig i18nConfig;
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUser(Locale locale){
        return i18nConfig.messageSource("welcome.message");
    }

    @PostMapping("/login")
    public ResponseData<?> login(@Valid @RequestBody UserRequetLogin user){
        Long new_userid = userService.login(user);
        return new ResponseData<Long>(200, i18nConfig.messageSource("user.login.success"), new_userid);
    }
    @PostMapping("/register")
    public ResponseData<?> register(@Valid @RequestBody UserRequestRegister user){
        Long new_userid = userService.register(user);
        return new ResponseData<Long>(200, i18nConfig.messageSource("user.login.success"), new_userid);
    }
}
