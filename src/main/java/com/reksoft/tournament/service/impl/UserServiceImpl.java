package com.reksoft.tournament.service.impl;

import com.reksoft.tournament.dto.UserDto;
import com.reksoft.tournament.mapper.UserMapper;
import com.reksoft.tournament.repository.UserRepository;
import com.reksoft.tournament.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServicempl
 *
 * @author Ivan Efanov
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Override
    public void saveUser(UserDto dto) {
        userRepository.save(userMapper.toUser(dto));
    }

    @Override
    public UserDto findUserByLogin(String login) {
        return userMapper.toUserDto(userRepository.findByLogin(login));
    }
}
