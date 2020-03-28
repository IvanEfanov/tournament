package com.reksoft.tournament.dto;

import lombok.*;

/**
 * LoginDto
 *
 * @author Ivan Efanov
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    /*
     Login field.
    */
    private String login;

    /*
     Password field.
    */
    private String password;

}
