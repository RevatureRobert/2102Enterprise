package com.crunch.services;

import com.crunch.people.User;

class MembershipService {

    public User makeUser(String username, String password, String phoneNumber, String email){
        return new User(String username, String password, String phoneNumber, String email);
    }
}
