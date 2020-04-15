package org.charlie.rapbattle.persistance;

import org.charlie.rapbattle.model.User;

public class UserDao extends GenericDao<User>{

    public UserDao(){
        super(User.class);
    }

}
