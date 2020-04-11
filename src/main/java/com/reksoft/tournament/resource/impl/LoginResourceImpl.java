package com.reksoft.tournament.resource.impl;

import com.reksoft.tournament.dto.UserDto;
import com.reksoft.tournament.resource.LoginResource;
import com.reksoft.tournament.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginResourceImpl
 *
 * @author Ivan Efanov
 */
@Controller
public class LoginResourceImpl implements LoginResource {

    @Autowired
    private UserService userService;

    @Override
    public ModelAndView handleLogin() {
        return new ModelAndView("auth/login");
    }

    @Override
    public ModelAndView getRegistrationPage() {
        return new ModelAndView("auth/registration");
    }

    @Override
    public void createUser(UserDto dto) {
        userService.saveUser(dto);
    }
}
