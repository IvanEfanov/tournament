package com.reksoft.tournament.entity;

import com.reksoft.tournament.enums.UserProfileType;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Role
 *
 * @author Ivan Efanov
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rt_role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE", length = 15, unique = true, nullable = false)
    private String type = UserProfileType.USER.getUserProfileType();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> associatedUsers;

    @Override
    public String getAuthority() {
        return getType();
    }
}
