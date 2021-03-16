package com.dealership;

import com.dealership.database.ConnectionUtil;
import com.dealership.model.DealershipUser;
import com.dealership.service.CustomerService;
import com.dealership.service.EmployeeService;
import com.dealership.service.UserService;
import com.dealership.ui.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Driver {

    private final static Logger log = LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        ConnectionUtil connectionUtil = new ConnectionUtil();
        Connection connection = connectionUtil.getConnection();
        Scanner scanner = new Scanner(System.in);
        log.info("Scanner created");


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
