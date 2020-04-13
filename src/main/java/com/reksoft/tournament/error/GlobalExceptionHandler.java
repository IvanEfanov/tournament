package com.reksoft.tournament.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;



/**
 * GlobalExceptionHandler
 *
 * @author Ivan Efanov
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(Throwable.class)
    public ModelAndView genericExceptionHandler(Exception ex) {

        String errorMessage = ex.getMessage();
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorMessage", errorMessage);
        mv.addObject("stackTrace", ex.getStackTrace());
        return mv;
    }
}
