package com.crunch.services;

import com.crunch.model.User;

/**
 * A service for performing membership tasks
 * <p>
 * TODO: schedule workouts
 * TODO: only members can schedule workouts
 * TODO: holiday schedule or other closures
 * TODO: Notify members of membership expiration
 */
public class CalendarService {

    public static final int MAXIMUM_CAPACITY = 3;
    static int currentlyCheckedIn = 0;
    static User[] checkedIn = new User[3];

    enum status {
        ALREADY_CHECKED_IN,
        FULL_GYM,
        SUCCESSFULLY_CHECKED_IN;

        @Override
        public String toString() {
            return super.toString();
        }
    }


    //TODO: continue with this method and finish implementation.
    public status checkIn(User u) {
        if (currentlyCheckedIn <= 2 ) {
            if (!isUserCheckedIn(u)) {
                checkedIn[currentlyCheckedIn] = u;
                currentlyCheckedIn++;
                return status.SUCCESSFULLY_CHECKED_IN;
            } else {
                return status.ALREADY_CHECKED_IN;
            }
        }
        return status.FULL_GYM;
    }

    // return the index of the user and -1 if they dont exist in it
    public int getCheckedInPosition(User u) {
        int i = 0;
        for (; i <= currentlyCheckedIn; i++) {
            if (checkedIn[i].equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isUserCheckedIn(User u) {
        return getCheckedInPosition(u) > -1;
    }

    public int numberOfSpotsAvailable(){
        return MAXIMUM_CAPACITY - currentlyCheckedIn;
    }
}
