package org.charlie.rapbattle.services;

import org.charlie.rapbattle.exceptions.UserNotFoundException;
import org.charlie.rapbattle.model.User;
import org.charlie.rapbattle.persistance.jpa.JpaUserDao;

public class UserServices implements Services {

    private JpaUserDao userDao;

    public User getUser(Integer id){
        return userDao.findById(id);
    }

    public double getRating(Integer id) throws UserNotFoundException {
        User user = userDao.findById(id);

        if(user == null){
            throw new UserNotFoundException();
        }

        return userDao.getRating(id);
    }


    /**
     * Getters and setters
     */

    public JpaUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(JpaUserDao userDao) {
        this.userDao = userDao;
    }
}
