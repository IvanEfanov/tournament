package com.reksoft.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * BaseRepository
 *
 * @author Ivan Efanov
 */
@NoRepositoryBean
public interface BaseRepository<T,I extends Serializable> extends JpaRepository<T,I>, JpaSpecificationExecutor<T> {
}
