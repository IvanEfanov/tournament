package com.reksoft.tournament.mapper;

import com.reksoft.tournament.dto.UserDto;
import com.reksoft.tournament.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * UserMapper
 *
 * @author Ivan Efanov
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserDto dto);
}
