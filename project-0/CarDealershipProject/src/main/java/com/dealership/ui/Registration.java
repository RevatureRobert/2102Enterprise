package com.dealership.ui;

import com.dealership.model.DealershipUser;
import com.dealership.service.UserService;

import java.sql.Connection;
import java.util.Scanner;

public class Registration {

    final static String EMPLOYEE_VERIFICATION_CODE = "password";
    final String EMPLOYEE = "1";
    final String CUSTOMER = "2";


    public void greeting() {
        System.out.println("Welcome to the Car Dealership");
    }

    public String userLogin(Scanner scan) {
        System.out.print("Would you like to register as a:\n");
        System.out.println(EMPLOYEE + ". Employee\n" + CUSTOMER + ". Customer\n3. Exit");
        while (true) {
            String userChoice = scan.nextLine();
            if (userChoice.equals(EMPLOYEE)) {
                return "e";
            } else if (userChoice.equals(CUSTOMER)) {
                return "c";
            } else if (userChoice.equals("3")) {
                return "q";
            } else {
                System.out.println("That is an invalid entry. Please choose one of the three options");
            }
        }
    }

    public DealershipUser createUser(Scanner scanner, String registrationType) {
        DealershipUser user = new DealershipUser();
        System.out.println("Please enter information");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        String userType = CUSTOMER;
        if (registrationType.equals("e")) {
            userType = isEmployee(scanner);
            if (userType.equals("q")) {
                return user;
            }
        }
        return new DealershipUser(username, password, firstName, lastName, Integer.parseInt(userType));
    }


    public String isEmployee(Scanner scanner) {
        System.out.println("Please enter employee verification code: ");
        while (true) {
            String verificationCode = scanner.nextLine();
            if (EMPLOYEE_VERIFICATION_CODE.equals(verificationCode)) {
                return EMPLOYEE;
            } else if (verificationCode.equals(CUSTOMER)) {
                break;
            } else if (verificationCode.equals("q")) {
                return "q";
            } else {
                System.out.println("Invalid entry. Press \"q\" to Quit or " + CUSTOMER + " if you want to register as a customer.");
            }
        }
        return CUSTOMER;
    }

    public DealershipUser registerNewUser(Connection connection, Scanner scanner, UserService userService) {
        greeting();
        DealershipUser user;
        String userResponse = userLogin(scanner);
        if (userResponse.equals("q")) {
            return new DealershipUser();
        } else {
            user = createUser(scanner, userResponse);
            if (user.getFirstName() != null) {
                int result = userService.save(user, connection);
                System.out.println(result);
                return user;
            }
        }
        return new DealershipUser();
    }

}
