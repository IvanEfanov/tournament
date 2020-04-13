package com.reksoft.tournament.resource;

import com.reksoft.tournament.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginResource
 *
 * @author Ivan Efanov
 */
public interface LoginResource {

    @GetMapping({"/", "/login"})
    ModelAndView handleLogin();

    @GetMapping("/registration")
    ModelAndView getRegistrationPage();

    @PostMapping(value = "/registration")
    @ResponseStatus(value = HttpStatus.OK)
    void createUser(@RequestBody UserDto dto);
}
