package com.crunch.ui;

import com.crunch.model.User;

import java.util.Scanner;

public class MemberMenu extends AbstractMenu {

    private User u;


    @Override
    public void showMenu(Scanner scan) {

        System.out.println("1. check in");
        System.out.println("2. exit");
        switch (scan.nextLine()){
            case "1":
                new CheckInMenu(u).showMenu(scan);
                break;
            default:
                showMenu(scan);
                return;
        }
    }

    public MemberMenu(User u) {
        this.u = u;
    }
}
