package com.crunch.ui;

import com.crunch.exception.CurrentlyCheckedInException;
import com.crunch.model.User;
import com.crunch.services.CalendarService;

import java.util.Currency;
import java.util.Scanner;

public class CheckInMenu extends AbstractMenu{

    private User u;
    private CalendarService cs;


    @Override
    public void showMenu(Scanner scan) {
        System.out.println("Hello welcome: " + u.getUsername());
        if(cs.numberOfSpotsAvailable() == 0){
            System.out.println("sorry, the gym is full");
        } else {
            System.out.println(cs.numberOfSpotsAvailable() + " number of spots available");
            if(ui.yOrN(scan, "would you like to check in")){
                try {
                    System.out.println(cs.checkIn(u));
                } catch (CurrentlyCheckedInException e){
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("sit tight sugar");
                return;
            }
        }
    }



    public CheckInMenu(User u){
        this.u = u;
        this.cs = new CalendarService();
        this.ui = new UIUtility();
    }
}
