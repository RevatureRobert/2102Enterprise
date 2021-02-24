package com.crunch.services;

import com.crunch.people.User;


/**
 * for the user array, we should not care about the order they are added in,
 *      There should not be duplicates, if we reach the max size then it should
 *      be expandable, index should always point to the last valid object, and
 *      should never have gaps.
 */
public class UserService {


    private static User[] users = new User[5];
    // TODO: potential risk of overriting users if index is not incremented and decremented carefully
    private static int currentIndex = -1;


    public boolean doesUsernameExist(String username){
        // O(n) time complexity O(1) space complexity
        System.out.println(users.length);
        if(currentIndex > -1) {
            for (int i = 0; i < currentIndex; i++) {
                if (users[i].getUsername().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public User findUserByUsername(String username){
        // O(n) time complexity O(1) space complexity
        for(int i = 0; i < users.length; i++){
            if(users[i].getUsername().equals(username)){
                return users[i];
            }
        }
        return null;
    }


    // TODO: Ensure duplicates do not exist, while minimizing calls to doesUsernameExist method.
    public boolean makeUser(String username, String password, String phoneNumber, String email){
        if(!doesUsernameExist(username)){
            if((currentIndex + 1) < users.length){
                if(users[currentIndex+1] == null){
                    users[++currentIndex] = new User(username, password, phoneNumber, email);
                    return true;
                }
            }
        } else {
            System.out.println("user already exists");
        }
        return false;
    }
}
