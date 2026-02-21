package com.crm.services;

import java.util.List;

import org.hibernate.Session;

import com.crm.config.HibernateUtil;
import com.crm.entities.Customer;
import com.crm.entities.Order;

public class OrderService {

    public void getOrdersByCustomerId(Long customerId) {

        Session session = HibernateUtil.getSession();

        Customer customer = session.get(Customer.class, customerId);

        if (customer == null) {
            System.out.println("Customer Not Found");
            session.close();
            return;
        }

        List<Order> orders = customer.getOrderlist();

        if (orders == null || orders.isEmpty()) {
            System.out.println("No Orders Found");
            session.close();
            return;
        }

        for (Order o : orders) {
            System.out.println("Order ID: " + o.getOrderId());
            System.out.println("Date: " + o.getOrderDate());
            System.out.println("Amount: " + o.getTotalAmount());
            System.out.println("----------------------");
        }

        session.close();
    }

    public void calculateTotalAmount(Long customerId) {

        Session session = HibernateUtil.getSession();

        Customer customer = session.get(Customer.class, customerId);

        if (customer == null) {
            System.out.println("Customer Not Found");
            session.close();
            return;
        }

        double total = 0;

        for (Order o : customer.getOrderlist()) {
            total += o.getTotalAmount();
        }

        System.out.println("Total Amount: " + total);

        session.close();
    }
}