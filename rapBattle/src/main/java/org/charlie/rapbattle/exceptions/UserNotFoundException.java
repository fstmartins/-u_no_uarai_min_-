package org.charlie.rapbattle.exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(){
        super(ErrorMessages.USER_NOT_FOUND);
    }

}
