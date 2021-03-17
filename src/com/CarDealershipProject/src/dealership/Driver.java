package com.CarDealershipProject.src.dealership;

import com.CarDealershipProject.src.dealership.database.ConnectionUtil;
import com.CarDealershipProject.src.dealership.model.DealershipUser;
import com.CarDealershipProject.src.dealership.service.CustomerService;
import com.CarDealershipProject.src.dealership.service.EmployeeService;
import com.CarDealershipProject.src.dealership.service.UserService;
import com.CarDealershipProject.src.dealership.ui.Login;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Driver {


    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        ConnectionUtil connectionUtil = new ConnectionUtil();
        Connection connection = connectionUtil.getConnection();
        Scanner scanner = new Scanner(System.in);


        Login login = new Login();
        boolean runProgram = true;
        while (runProgram) {
            String title = "Dealership Service";
            System.out.println(title);
            for (int i = 0; i <= title.length(); i++) {
                System.out.print("*");
            }
            System.out.println();
            DealershipUser user = login.loginInformation(connection, scanner, userService);
            if (user.getUsername() != null) {
                if (userService.checkIfUserIsEmployeeOrOwner(user)) {
                    EmployeeService employeeService = new EmployeeService(userService, user, scanner);
                    employeeService.runEmployeeService(user, connection);
                } else {
                    CustomerService customerService = new CustomerService(user, scanner);
                    customerService.runCustomerService(user, connection);
                }

                if (scanner.nextLine().equalsIgnoreCase("q"))
                    break;
                else
                    continue;

            } else
                userService.goodByeCustomer();
                runProgram = false;
        }

    }
}
