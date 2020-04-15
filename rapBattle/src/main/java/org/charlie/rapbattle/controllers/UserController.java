package org.charlie.rapbattle.controllers;

import org.charlie.rapbattle.services.UserServices;

public class UserController {

    private UserServices userServices;




    /**
     * Getters and Setters
     */

    public UserServices getUserServices() {
        return userServices;
    }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }
}
