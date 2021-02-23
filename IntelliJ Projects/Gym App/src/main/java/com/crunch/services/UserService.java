package com.crunch.services;

import com.crunch.people.User;

public class UserService {

    private static User[] users = new User[5];
    private static int currentIndex = -1;

    //TODO: ensure duplicates do not exist while minimizing calls to doesUserExist
    public boolean makeUser(String username, String password, String phoneNumber, String email){
        User u = new User(username, password, phoneNumber, email);
        if(currentIndex + 1 < users.length){
            users[++currentIndex] = u;
            System.out.println("Created user at index: " + currentIndex);
            return true;
        }
        return false;
    }

    public boolean doesUserExist(String username){
        // O(n) time complexity
        // 0(1) space complexity
        return findUserByUsername(username) != null;
    }

    public User findUserByUsername(String username){
        // O(n) time complexity
        // 0(1) space complexity
        if(currentIndex > -1){
            for(int i = 0; i <= currentIndex; i++){
                if(users[i].getUsername().equals(username)){
                    System.out.println("Found user");
                    return users[i];
                }
            }
        }
        return null;
    }

}
