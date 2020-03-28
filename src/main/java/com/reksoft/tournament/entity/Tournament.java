package com.reksoft.tournament.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Tournament
 *
 * @author Ivan Efanov
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "tournament")
public class Tournament {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
}
