package com.crunch.services;

import com.crunch.model.User;

/**
 * A service for performing membership tasks
 *
 * TODO: schedule workouts
 * TODO: only members can schedule workouts
 * TODO: holiday schedule or other closures
 * TODO: Notify members of membership expiration
 */
public class CalendarService {
    static int currentlyCheckedIn = 0;
    static User[] checkedIn = new User[3];


    //TODO: continue with this method and finish implementation.
    public boolean checkIn(User u){
        if(currentlyCheckedIn <= 2) {
            for (int i = 0; i <= currentlyCheckedIn; i++) {
                if(checkedIn[i].equals(u)){
                    //TODO: implement the rest of the method
                    return true;
                }
            }
        }
        return true;
    }

}
