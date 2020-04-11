package com.reksoft.tournament.service;

import com.reksoft.tournament.dto.UserDto;

/**
 * UserService
 *
 * @author Ivan Efanov
 */
public interface UserService {

    void saveUser(UserDto dto);

    UserDto findUserByLogin(String login);
}
