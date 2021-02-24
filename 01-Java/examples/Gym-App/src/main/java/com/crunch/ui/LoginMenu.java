package com.crunch.ui;

import com.crunch.model.User;
import com.crunch.services.UserService;

import java.util.Scanner;

public class LoginMenu extends AbstractMenu {


    @Override
    public void showMenu(Scanner scan){

        for(int i =0; i <= 2; i++) {
            System.out.println("username: ");
            String username = scan.nextLine();
            System.out.println("password: ");
            String password = scan.nextLine();
            User u = new UserService().findUserByUsername(username);
            if (u == null || !u.getPassword().equals(password)) {
                System.out.println("login failed");
            } else {
                System.out.println("congratulations, have a great virtual workout");
                MemberMenu mm = new MemberMenu(u);
                mm.showMenu(scan);
                break;
            }
        }

    }
}
