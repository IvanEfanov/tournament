package com.reksoft.tournament.service;

import com.reksoft.tournament.dto.UserDto;
import com.reksoft.tournament.exception.UserLoginAlreadyUsedException;

/**
 * UserService
 *
 * @author Ivan Efanov
 */
public interface UserService {

    void saveUser(UserDto dto) throws UserLoginAlreadyUsedException;

    UserDto findUserByLogin(String login);
}
