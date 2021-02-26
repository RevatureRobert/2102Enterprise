package com.crunch.ui;

import java.util.Arrays;
import java.util.Scanner;

public class UIUtility {

    public  boolean yOrN(Scanner scan, String message){
        String answer = "";
            do{
                System.out.println(message + " y/n");
                answer = scan.nextLine();
                if(answer.equals("y")){
                    return true;
                } else if(answer.equals("n")){
                    return false;
                }
            } while(true);
    }
}

