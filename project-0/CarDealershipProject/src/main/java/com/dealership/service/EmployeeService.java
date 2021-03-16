package com.dealership.service;

import com.dealership.model.DealershipUser;
import com.dealership.model.Offer;

import java.sql.Connection;
import java.util.Scanner;

public class EmployeeService {

    private final UserService userService;
    private final DealershipUser user;
    Scanner scanner;


    public EmployeeService(UserService userService, DealershipUser user, Scanner scanner) {
        this.userService = userService;
        this.user = user;
        this.scanner = scanner;
    }

    public void runEmployeeService(DealershipUser user, Connection connection) {
        employeeGreeting(user);
        while (true) {
            int userOption;
            try {
                userOption = showEmployeeMenu(user);
            } catch (Exception e) {
                System.out.println("That is an invalid entry");
                continue;
            }
            switch (userOption) {
                case 1:
                    getDealershipInventory(user, connection);
                    displayOffers(connection, userService);
                    break;
                case 2:
                    getDealershipInventory(user, connection);
                    userService.acceptOffer(user, scanner, connection);
                    break;
                case 3:
                    userService.removeVehicleFromOffers(user, connection, scanner);
                    break;
                case 4:
                    getDealershipInventory(user, connection);
                    userService.removeVehicleFromInventory(user, connection, scanner);
                    break;
                case 5:
                    userService.addVehicle(user, connection, scanner);
                    break;
                case 6:
                    getDealershipInventory(user, connection);
                    userService.getCustomerPaymentHistory(connection, scanner);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("You have entered an invalid entry.\n");
                    continue;
            }

            if (userOption == 7) {
                break;
            }
        }
    }

    public void displayOffers(Connection connection, UserService userService) {
        Offer[] allOffers = userService.showAllOffers(connection, scanner);
        if (allOffers.length == 0) {
            System.out.println("There are no offers for the vehicle you requested.");
        } else {
            for (int i = 0; i < 1; i++) {
                System.out.println("Vehicle #: " + allOffers[i].getVehicleId());
            }
            for (Offer eachOffer : allOffers) {
                System.out.print("ID: " + eachOffer.getId());
                System.out.print(" | Offer Amount: $" + eachOffer.getOfferAmount());
                System.out.println(" | Customer #: " + eachOffer.getUserId());
            }
        }
//       chooseFromEmployeeMenu(allOffers, user, connection);
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

    public int showEmployeeMenu(DealershipUser user) {
        while (true) {
            System.out.println();
            String welcome = "Welcome to the Employee Menu";
            System.out.println(welcome);
            for (int i = 0; i <= welcome.length(); i++) {
                System.out.print("*");
            }
            System.out.println();
            System.out.println("1: See all offers");
            System.out.println("2: Accept an offer");
            System.out.println("3. Reject an offer");
            System.out.println("4. Remove a vehicle from the lot");
            System.out.println("5. Add a vehicle from the lot");
            System.out.println("6. View Payment History of a Customer");
            System.out.println("7. Exit");
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

    private void employeeGreeting(DealershipUser user) {
        System.out.println();
        System.out.println("Hello " + userService.capitalizeString(user.getFirstName()) + "!");
    }

}
