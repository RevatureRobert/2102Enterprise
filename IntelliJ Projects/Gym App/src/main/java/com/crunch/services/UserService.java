package com.crunch.services;

import com.crunch.people.User;

public class UserService {
    User[] users = new User[5];

    public boolean doesUserExist(String username){
        for(int i = 0; i < users.length; i++){
            if(users[i].getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
