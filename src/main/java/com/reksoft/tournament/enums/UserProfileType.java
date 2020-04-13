package com.reksoft.tournament.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * UserProfileType
 *
 * @author Ivan Efanov
 */
@Getter
@AllArgsConstructor
public enum UserProfileType implements Serializable {
    USER("USER"),
    ADMIN("ADMIN");

    String userProfileType;
}
