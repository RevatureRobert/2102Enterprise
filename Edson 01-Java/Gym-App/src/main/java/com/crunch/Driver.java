package com.crunch;

import com.crunch.people.User;
import com.crunch.ui.MembershipMenu;

public class Driver {

    public static void main(String[] args) {
//        System.out.println("We are in crunch");
//
//        User newUser = new User("Tommy");
//
//        System.out.println("Finished");

        MembershipMenu mm = new MembershipMenu();
        mm.CreateUserMenu();
    }
}
