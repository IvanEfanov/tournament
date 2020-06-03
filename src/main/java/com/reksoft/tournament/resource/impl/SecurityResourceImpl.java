package com.reksoft.tournament.resource.impl;

import com.reksoft.tournament.dto.UserDto;
import com.reksoft.tournament.entity.User;
import com.reksoft.tournament.exception.UserLoginAlreadyUsedException;
import com.reksoft.tournament.resource.SecurityResource;
import com.reksoft.tournament.service.MailService;
import com.reksoft.tournament.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SecurityResourceImpl
 *
 * @author Ivan Efanov
 */
@Controller
public class SecurityResourceImpl implements SecurityResource {

    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;

    @Override
    public ModelAndView handleLogin() {
        return new ModelAndView("auth/login");
    }

    @Override
    public ModelAndView logout() {
        return new ModelAndView("auth/login");
    }

    @Override
    public ModelAndView getRegistrationPage() {
        return new ModelAndView("auth/registration");
    }

    @Override
    public void createUser(UserDto dto) {
        try {
            userService.saveUser(dto);
            asyncMailSending(dto);
        } catch (UserLoginAlreadyUsedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ModelAndView getMain() {

        ModelAndView modelAndView = new ModelAndView("auth/main");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) auth.getPrincipal();
        modelAndView.addObject("login", principal.getLogin());
        modelAndView.addObject("name", principal.getLogin());
        return modelAndView;
    }

    @Override
    public ModelAndView getAuth() {
        return new ModelAndView("auth/main");
    }

    @Override
    public ModelAndView getSuccessRegistration() {
        return new ModelAndView("auth/successReg");
    }

    @Override
    public ModelAndView getSomethingWrong() {
        return new ModelAndView("auth/smthWrong");
    }

    private class MailThread extends Thread{
        @Setter
        private UserDto dto;

        @Override
        public void run() {
            mailService.sendEmailSuccessUserRegistration(dto);
        }
    }

    private void asyncMailSending(UserDto dto) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            MailThread mailThread = new MailThread();
            mailThread.setDto(dto);
            mailThread.start();
        });
    }
}
