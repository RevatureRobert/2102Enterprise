package com.crunch.ui;

import com.crunch.people.User;
import com.crunch.services.MembershipService;
import com.crunch.services.UserService;

import java.util.Scanner;

public class MembershipMenu {
    UserService us = new UserService();

    public void CreateUserMenu(){
        Scanner scan = new Scanner(System.in);
        String username = "";
        boolean cont = false;
        System.out.println("===Welcome to Crunch===");
        do{
            do{
                System.out.println("Provide username");
                username = scan.nextLine();
            }while(us.doesUserExist(username));
            System.out.println("Provide password");
            String password = scan.nextLine();
            System.out.println("Provide phone number");
            String phoneNumber = scan.nextLine();
            System.out.println("Provide email");
            String email = scan.nextLine();
            us.makeUser(username,password,phoneNumber,email);
            System.out.println("Would you like to continue? (y/n)");
            if(scan.nextLine().equals("y")){
                cont = true;
            }
        } while(cont);
    }
}
