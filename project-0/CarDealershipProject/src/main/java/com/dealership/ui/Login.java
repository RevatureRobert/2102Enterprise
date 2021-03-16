package com.dealership.ui;

import com.dealership.model.DealershipUser;
import com.dealership.service.UserService;

import java.sql.Connection;
import java.util.Scanner;


public class Login {

    public Login() {
    }

    private String askUsername(Scanner scanner) {
        System.out.print("Please enter your username: ");
        String username = scanner.nextLine();
        return username.toLowerCase();
    }

    private String askPassword(Scanner scanner) {
        System.out.print("Please enter your password: ");
        return scanner.nextLine();
    }

    public DealershipUser loginInformation(Connection connection, Scanner scanner, UserService userService) {

        boolean continueToLogin = true;
        String response;
        DealershipUser user;
        while (continueToLogin) {
            System.out.println("Please press any key to login or press \"q\" to quit");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                return new DealershipUser();
            }
            String username = askUsername(scanner);
            String password = askPassword(scanner);
            user = userService.loginQuery(connection, username, password);

            if (user.getFirstName() == null) {
                System.out.println("Sorry. You have entered an invalid username or password.");
                System.out.print("Press any key to continue, \"q\" to quit or \"r\" to register: ");
                response = scanner.nextLine();
                if (response.equalsIgnoreCase("q")) {
                    return new DealershipUser();
                } else if (response.equalsIgnoreCase("r")) {
                    Registration registration = new Registration();
                    user = registration.registerNewUser(connection, scanner, userService);
                } else {
                    continue;
                }
            }
            return user;
        }
        return new DealershipUser();
    }
}
