package com.crunch;

import com.crunch.ui.LoginMenu;
import com.crunch.ui.SignUpMenu;

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

        SignUpMenu mm = new SignUpMenu();
        LoginMenu lm = new LoginMenu();
        Scanner scan = new Scanner(System.in);
        boolean continueLoop = true;
        do {
            System.out.println("sign up, login or exit?");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("exit")){
                continueLoop = false;
            } else if(answer.equalsIgnoreCase("sign up")) {
                mm.showMenu(scan);
            } else if(answer.equalsIgnoreCase("login")) {
                lm.showMenu(scan);
            }
        } while(continueLoop);

    }


}
