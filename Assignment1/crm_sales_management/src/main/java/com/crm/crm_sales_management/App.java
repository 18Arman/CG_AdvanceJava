package com.crm.crm_sales_management;

import java.util.Scanner;

import com.crm.services.CustomerService;
import com.crm.services.LeadService;
import com.crm.services.OrderService;
import com.crm.config.HibernateUtil;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        LeadService leadService = new LeadService();
        OrderService orderService = new OrderService();

        int choice = 0;

        while (true) {

            System.out.println("\n===== CRM SALES MANAGEMENT =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Get Customer By ID");
            System.out.println("5. Display All Customers");
            System.out.println("6. Get Lead By ID");
            System.out.println("7. Get Orders By Customer ID");
            System.out.println("8. Calculate Total Order Amount");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    customerService.addCustomer();
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    Long updateId = sc.nextLong();
                    sc.nextLine();
                    customerService.updateCustomer(updateId);
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    Long deleteId = sc.nextLong();
                    sc.nextLine();
                    customerService.deleteCustomer(deleteId);
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    Long getId = sc.nextLong();
                    sc.nextLine();
                    customerService.getCustomer(getId);
                    break;

                case 5:
                    customerService.displayAllCustomers();
                    break;

                case 6:
                    System.out.print("Enter Lead ID: ");
                    Long leadId = sc.nextLong();
                    sc.nextLine();
                    leadService.getLeadById(leadId);
                    break;

                case 7:
                    System.out.print("Enter Customer ID: ");
                    Long orderCustomerId = sc.nextLong();
                    sc.nextLine();
                    orderService.getOrdersByCustomerId(orderCustomerId);
                    break;

                case 8:
                    System.out.print("Enter Customer ID: ");
                    Long totalCustomerId = sc.nextLong();
                    sc.nextLine();
                    orderService.calculateTotalAmount(totalCustomerId);
                    break;

                case 9:
                    System.out.println("Exiting Application...");
                    HibernateUtil.shutdown();
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}