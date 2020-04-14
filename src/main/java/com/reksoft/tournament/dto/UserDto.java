package com.reksoft.tournament.dto;

import lombok.*;

/**
 * UserDto
 *
 * @author Ivan Efanov
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String login;

    private String password;

    private String fullName;

    private String email;
}
