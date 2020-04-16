package org.charlie.rapbattle.services;

import org.charlie.rapbattle.exceptions.UserNotFoundException;
import org.charlie.rapbattle.model.User;
import org.charlie.rapbattle.persistance.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements Services {

    private UserDao userDao;

    public User getUser(Integer id){
        return userDao.findById(id);
    }

    public User findByEmail(String email){
        return userDao.findByEmail(email);
    }

    public double getRating(Integer id) throws UserNotFoundException {
        User user = userDao.findById(id);

        if(user == null){
            throw new UserNotFoundException();
        }

        return user.getBattlesWon();
    }

    @Transactional
    public void addUser(User user) {
        userDao.saveOrUpdate(user);
    }

    @Transactional
    public void saveUser(User user){
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
