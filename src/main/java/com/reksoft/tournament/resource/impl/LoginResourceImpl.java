package com.reksoft.tournament.resource.impl;

import com.reksoft.tournament.dto.LoginDto;
import com.reksoft.tournament.resource.LoginResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginResourceImpl
 *
 * @author Ivan Efanov
 */
@Controller
public class LoginResourceImpl implements LoginResource {

    @Override
    public ModelAndView handleLogin() {
        return new ModelAndView("auth/login");
    }

    @Override
    public ModelAndView getRegistrationPage() {
        return new ModelAndView("auth/registration");
    }
}
