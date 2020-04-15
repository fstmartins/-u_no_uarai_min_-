package org.charlie.rapbattle.services;

import org.charlie.rapbattle.exceptions.UserNotFoundException;
import org.charlie.rapbattle.model.User;
import org.charlie.rapbattle.persistance.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

    public void addUser(User user) {
        userDao.saveOrUpdate(user);
    }

    /**
     * Getters and setters
     */

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
