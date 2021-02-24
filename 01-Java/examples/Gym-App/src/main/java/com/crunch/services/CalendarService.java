package com.crunch.services;

import com.crunch.exception.CurrentlyCheckedInException;
import com.crunch.model.User;

/**
 * A service for performing membership tasks
 * <p>
 * TODO: schedule workouts
 * TODO: only members can schedule workouts
 * TODO: holiday schedule or other closures
 * TODO: Notify members of membership expiration
 *
 * Checked in array should: not contain duplicates, be able to
 *      view a list of all checked in users, move users from index
 *      to index, time limit on being in the array, we should not
 *      care about the order they are added in, should be of static
 *      size and have a maximum amount, index should always point to
 *      the last valid object, and should never have gaps.
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
    public status checkIn(User u) throws CurrentlyCheckedInException{
        if (currentlyCheckedIn <= 2 ) {
            if (!isUserCheckedIn(u)) {
                checkedIn[currentlyCheckedIn] = u;
                currentlyCheckedIn++;
                return status.SUCCESSFULLY_CHECKED_IN;
            } else {
//                return status.ALREADY_CHECKED_IN;
                throw new CurrentlyCheckedInException("The User is already checked in");
            }
        }
        return status.FULL_GYM;
    }

    // return the index of the user and -1 if they dont exist in it
    public int getCheckedInPosition(User u) {
        int i = 0;
        for (; i <= currentlyCheckedIn; i++) {
            if (checkedIn[i] != null && checkedIn[i].equals(u)) {
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
