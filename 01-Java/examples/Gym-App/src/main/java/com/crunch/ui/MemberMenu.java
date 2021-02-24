package com.crunch.ui;

import com.crunch.model.User;

import java.util.Scanner;

public class MemberMenu extends AbstractMenu {

    private User u;


    @Override
    public void showMenu(Scanner scan) {

        System.out.println("1. check in");
        System.out.println("2. exit");
        int answer = scan.nextInt();
        switch (answer){
            case 1:
                new CheckInMenu(u).showMenu(scan);
                break;
        }
    }

    public MemberMenu(User u) {
        this.u = u;
    }
}
