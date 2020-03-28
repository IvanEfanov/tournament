package com.reksoft.tournament.resource;

import com.reksoft.tournament.dto.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginResource
 *
 * @author Ivan Efanov
 */
public interface LoginResource {

    @PostMapping("/login")
    ModelAndView handleLogin(@RequestBody LoginDto dto);
}
