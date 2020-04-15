package org.charlie.rapbattle.persistance;

import org.charlie.rapbattle.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDao<User>{

    public UserDao(){
        super(User.class);
    }

}
