package com.crunch.ui;

import com.crunch.people.User;
import com.crunch.services.MembershipService;
import com.crunch.services.UserService;

import java.util.Scanner;

/**
 * Scopes
 *  static (class)
 *  instance (object)
 *  method
 *  local (block)
 *
 *
 *
 */

public class MembershipMenu {

    public void CreateUserMenu(){
        Scanner scan = new Scanner(System.in);

        UserService us = new UserService();
        boolean exist = false;
        System.out.println("====Welcome to Crunch====");
        String username = "";
        do{
            System.out.println("provide username");
            username = scan.nextLine();
            exist = us.doesUsernameExist(username);
        } while(!exist);
        System.out.println("provide password");
        String password = scan.nextLine();
        System.out.println("provide phone number");
        String phoneNumber = scan.nextLine();
        System.out.println("provide email");
        String email = scan.nextLine();
        MembershipService mem = new MembershipService();
        User u = mem.makeUser(username, password, phoneNumber, email);
        System.out.println(u);
    }
}
