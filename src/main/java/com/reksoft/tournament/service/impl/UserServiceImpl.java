package com.reksoft.tournament.service.impl;

import com.reksoft.tournament.dto.UserDto;
import com.reksoft.tournament.entity.Role;
import com.reksoft.tournament.entity.User;
import com.reksoft.tournament.exception.UserLoginAlreadyUsedException;
import com.reksoft.tournament.mapper.UserMapper;
import com.reksoft.tournament.repository.RoleRepository;
import com.reksoft.tournament.repository.UserRepository;
import com.reksoft.tournament.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static com.reksoft.tournament.enums.UserProfileType.USER;
import static java.util.Collections.singleton;
import static java.util.Objects.nonNull;

/**
 * UserServicempl
 *
 * @author Ivan Efanov
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Override
    @Transactional
    public void saveUser(UserDto dto) throws UserLoginAlreadyUsedException {
        if (nonNull(userRepository.findByLogin(dto.getLogin()))) {
            throw new UserLoginAlreadyUsedException("This login already used");
        }

        User user = userMapper.toUser(dto);
        user.setPassword(encoder.encode(dto.getPassword()));
        Role role = roleRepository.findByType(USER.getUserProfileType());
        Set<User> associatedUsers = role.getAssociatedUsers();
        associatedUsers.add(user);
        role.setAssociatedUsers(associatedUsers);
        roleRepository.save(role);
        user.setRoles(singleton(role));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDto findUserByLogin(String login) {
        return userMapper.toUserDto(userRepository.findByLogin(login));
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
