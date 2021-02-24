package com.crunch;

import com.crunch.ui.MembershipMenu;

import java.util.Scanner;

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
        Scanner scan = new Scanner(System.in);
        boolean continueLoop = true;
        do {
            System.out.println("do you want to create a new user? y/n");
            String answer = scan.nextLine();
            if(answer.equals("n")){
                continueLoop = false;
            } else if(answer.equals("y")) {
                mm.CreateUserMenu();
            } else {

            }
        } while(continueLoop);

    }


}
