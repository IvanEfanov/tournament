package com.reksoft.tournament.exception;

/**
 * UserLoginAlreadyUsedException
 *
 * @author Ivan Efanov
 */
public class UserLoginAlreadyUsedException extends Exception {

    public UserLoginAlreadyUsedException(String message) {
        super(message);
    }
}
