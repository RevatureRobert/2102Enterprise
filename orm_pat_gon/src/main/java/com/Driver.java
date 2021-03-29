package com;

import com.model.Customer;
import com.service.MyEntityManager;

public class Driver {
    public static void main(String args[]) {
        Customer cust = new Customer("Pat", "Gon", 1);
        Customer cust2 = new Customer("Mike", "Jordan", 2);
        Customer cust3 = new Customer("Magic", "Johnson", 3);
        MyEntityManager em = new MyEntityManager();

        // Create and Insert
        em.createTable(cust);
        em.persist(cust);
        em.getAll(Customer.class);

        //Update
        cust.setLastName("Gonzalez");
        em.merge(cust);
        em.getAll(Customer.class);

        // Insert and Read
        em.persist(cust2);
        System.out.println(em.find(Customer.class, 2));

        // Removal and Drop
        em.remove(cust);
        em.getAll(Customer.class);
        em.dropTable(Customer.class);


    }

}
