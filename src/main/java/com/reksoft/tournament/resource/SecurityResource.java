package com.reksoft.tournament.resource;

import com.reksoft.tournament.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * SecurityResource
 *
 * @author Ivan Efanov
 */
public interface SecurityResource {

    @GetMapping({"/"})
    ModelAndView handleLogin();

    @GetMapping("/registration")
    ModelAndView getRegistrationPage();

    @PostMapping(value = "/registration")
    @ResponseStatus(value = HttpStatus.OK)
    void createUser(@RequestBody UserDto dto);

    @GetMapping(value = "/main")
    ModelAndView getMain();

    @GetMapping(value = "/login")
    ModelAndView getAuth();

    @GetMapping(value = "/logout")
    ModelAndView logout();

    @GetMapping(value = "/success-reg")
    ModelAndView getSuccessRegistration();

    @GetMapping(value = "/smth-wrong")
    ModelAndView getSomethingWrong();

}
