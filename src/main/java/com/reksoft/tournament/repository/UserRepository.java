package com.reksoft.tournament.repository;

import com.reksoft.tournament.entity.User;

/**
 * UserRepository
 *
 * @author Ivan Efanov
 */
public interface UserRepository extends BaseRepository<User, Long> {

    User findByLogin(String login);

    User findByFullName(String name);

}
