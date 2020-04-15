package org.charlie.rapbattle.services;

import org.charlie.rapbattle.exceptions.UserNotFoundException;
import org.charlie.rapbattle.model.User;
import org.charlie.rapbattle.persistance.UserDao;

public class UserServices implements Services {

    private UserDao userDao;

    public User getUser(Integer id){
        return userDao.findById(id);
    }

    public double getRating(Integer id) throws UserNotFoundException {
        User user = userDao.findById(id);

        if(user == null){
            throw new UserNotFoundException();
        }

        return user.getBattlesWon();
    }


    /**
     * Getters and setters
     */

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
