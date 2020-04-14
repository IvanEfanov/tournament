package com.reksoft.tournament.service.impl;

import com.reksoft.tournament.dto.UserDto;
import com.reksoft.tournament.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * MailServiceImpl
 *
 * @author Ivan Efanov
 */
@Service
public class MailServiceImpl implements MailService {

    private static final String SUBJECT_REG_NEW_USER_MAIL = "Welcome!";
    private static final String TEXT_REG_NEW_USER_MAIL = "Hello! You have been registered successfully! \n";

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmailSuccessUserRegistration(UserDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getEmail());
        message.setSubject(SUBJECT_REG_NEW_USER_MAIL);
        message.setText(getTextOfRegNewUserMail(dto));

        mailSender.send(message);
    }

    private String getTextOfRegNewUserMail(UserDto dto) {
        return TEXT_REG_NEW_USER_MAIL +
                "Login : " + dto.getLogin() +
                "\n" +
                "Password : " + dto.getPassword();
    }
}
