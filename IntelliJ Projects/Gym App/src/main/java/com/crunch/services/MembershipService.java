package com.crunch.services;

import com.crunch.people.User;

/*
    A service to perform membership tasks
 */

public class MembershipService {

    public User makeUser(String username, String password, String phoneNumber, String email){
        return new User(username, password, phoneNumber, email);
    }
}
