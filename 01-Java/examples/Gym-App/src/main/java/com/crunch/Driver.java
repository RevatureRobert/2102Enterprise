package com.crunch;

import com.crunch.ui.MembershipMenu;

public class Driver {

    public static void main(String[] args) {
//        System.out.println("we are in crunch");

    //we want to create a User object
        // calling the constructor, Java does provide a default constructor
//        User newUser = new User("fred");
//        System.out.println(newUser.getUsername());
//        newUser.setUsername("harry");
//        System.out.println(newUser.getUsername());
//
//        System.out.println(newUser);
//
//        System.out.println("finished");

        MembershipMenu mm = new MembershipMenu();
        mm.CreateUserMenu();

    }


}
