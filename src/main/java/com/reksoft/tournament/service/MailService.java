package com.reksoft.tournament.service;

import com.reksoft.tournament.dto.UserDto;

/**
 * MailService
 *
 * @author Ivan Efanov
 */
public interface MailService {

    void sendEmailSuccessUserRegistration(UserDto dto);
}
