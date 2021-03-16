package com.dealership.service;

import com.dealership.model.DealershipUser;
import com.dealership.model.Offer;

import java.sql.Connection;
import java.util.Scanner;

public class CustomerService {

    private UserService userService = new UserService();
    private DealershipUser user;
    private Scanner scanner;

    public CustomerService() {
        showCustomerMenu(user);
    }

    public CustomerService(DealershipUser user, Scanner scanner) {
        this.user = user;
        this.scanner = scanner;
    }

    public void runCustomerService(DealershipUser user, Connection connection) {
        customerGreeting(user);
        String[] myVehicles;
        while (true) {
            int userOption;
            try {
                userOption = showCustomerMenu(user);
            } catch (Exception e) {
                System.out.println("That is an invalid entry");
                continue;
            }
            switch (userOption) {
                case 1:
                    getDealershipInventory(user, connection);
                    break;
                case 2:
                    getMyVehicles(userService, user, connection);
                    break;
                case 3:
                    getDealershipInventory(user, connection);
                    Offer offer = userService.makeOffer(user, userService, scanner, connection);
                    break;
                case 4:
                    myVehicles = getMyVehicles(userService, user, connection);
                    if (myVehicles.length != 0)
                        userService.makePayment(user, connection, scanner);
                    break;
                case 5:
                    myVehicles = getMyVehicles(userService, user, connection);
                    if (myVehicles.length != 0)
                        userService.viewPaymentHistoryByVin(user, connection, scanner);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("You have entered an invalid entry.");
                    continue;
            }

            if (userOption == 6) {
                break;
            }
        }


    }

    private void customerGreeting(DealershipUser user) {
        System.out.println();
        System.out.println("Hello " + userService.capitalizeString(user.getFirstName()) + "!");
    }

    public int showCustomerMenu(DealershipUser user) {
        while (true) {
            System.out.println();
            String welcome = "Welcome to the Customer Menu";
            System.out.println(welcome);
            for (int i = 0; i <= welcome.length(); i++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.println("1. Show Dealership Inventory");
            System.out.println("2. Show Cars You Own");
            System.out.println("3. Make an Offer");
            System.out.println("4. Make a Payment");
            System.out.println("5. View Payment History");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("--> ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("You have entered an invalid entry or press \"q\" to exit or any key to continue.");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("q")) {
                    return -1;
                } else
                    continue;
            }
        }
    }

    public String[] getMyVehicles(UserService userService, DealershipUser user, Connection connection) {
        String[] myVehicles;
        myVehicles = userService.viewUserVehicles(user, connection);
        System.out.println();
        System.out.println("Cars Owned by " + userService.capitalizeString(user.getFirstName()));

        for (String eachVehicle : myVehicles) {
            System.out.println(eachVehicle);
        }

        return myVehicles;
    }

    public String[] getDealershipInventory(DealershipUser user, Connection connection) {
        String[] dealershipInventory = userService.viewDealershipInventory(user, connection);
        System.out.println("\n\nCar Dealership Currently Has " + dealershipInventory[dealershipInventory.length - 1] + " In Stock:");
        for (int i = 0; i < dealershipInventory.length - 1; i++) {
            System.out.println(dealershipInventory[i]);
        }
        return dealershipInventory;
    }

    public DealershipUser getUser() {
        return user;
    }

    public UserService getUserService() {
        return userService;
    }

}
