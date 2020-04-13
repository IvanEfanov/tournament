package com.reksoft.tournament.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


/**
 * GlobalExceptionHandler
 *
 * @author Ivan Efanov
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @PostMapping("/error")
    public ModelAndView genericExceptionHandler(Exception ex) {

        String errorMessage = ex.getMessage();
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorMessage", errorMessage);
        mv.addObject("stackTrace", ex.getStackTrace());
        return mv;
    }
}
