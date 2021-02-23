package com.crunch.ui;

import com.crunch.people.User;
import com.crunch.services.MembershipService;
import com.crunch.services.UserService;

import java.util.Scanner;

public class MembershipMenu {

    public void CreateUserMenu(){
        Scanner scan = new Scanner(System.in);
        UserService us = new UserService();
        String username = "";
        System.out.println("===Welcome to Crunch===");
        do{
            System.out.println("Provide username");
            username = scan.nextLine();
        }while(!us.doesUserExist(username));

        System.out.println("Provide password");
        String password = scan.nextLine();
        System.out.println("Provide phone number");
        String phoneNumber = scan.nextLine();
        System.out.println("Provide email");
        String email = scan.nextLine();

        MembershipService mem = new MembershipService();
        User u = mem.makeUser(username, password, phoneNumber, email);
        System.out.println(u);
    }
}
