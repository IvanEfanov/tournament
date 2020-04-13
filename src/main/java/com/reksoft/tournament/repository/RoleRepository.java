package com.reksoft.tournament.repository;

import com.reksoft.tournament.entity.Role;

/**
 * RoleRepository
 *
 * @author Ivan Efanov
 */
public interface RoleRepository extends BaseRepository<Role, Long> {

    Role findByType(String type);
}
