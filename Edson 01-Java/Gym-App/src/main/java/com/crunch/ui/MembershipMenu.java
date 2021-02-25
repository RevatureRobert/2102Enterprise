package com.crunch.ui;

import com.crunch.services.MembershipService;

import java.util.Scanner;


public class MembershipMenu {

    public void CreateUserMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("====Welcom to Crunch====");
        System.out.println("provide a username");
        String username = scan.nextLine();
        System.out.println("provide password");
        String password = scan.nextLine();
        System.out.println("provide phone number");
        String phoneNumber = scan.nextLine();
        System.out.println("provide an email");
        String email = scan.nextLine();

    }
}
