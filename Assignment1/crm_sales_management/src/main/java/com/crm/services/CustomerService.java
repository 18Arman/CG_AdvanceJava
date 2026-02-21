package com.crm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crm.config.HibernateUtil;
import com.crm.entities.Customer;
import com.crm.entities.Order;
import com.crm.entities.lead_cs;

public class CustomerService {

    private Scanner sc = new Scanner(System.in);

    public void addCustomer() {

        Session session = HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();

        try {

            Customer c1 = new Customer();

            System.out.print("Enter Name: ");
            c1.setName(sc.nextLine());

            System.out.print("Enter Email: ");
            c1.setEmail(sc.next());

            System.out.print("Enter Phone: ");
            c1.setPhone(sc.next());
            sc.nextLine();

            lead_cs l1 = new lead_cs();

            System.out.print("Enter Source: ");
            l1.setSource(sc.next());

            System.out.print("Enter Status: ");
            l1.setStatus(sc.next());
            sc.nextLine();

            c1.setLeadid(l1);

            System.out.print("Enter Number of Orders: ");
            int n = sc.nextInt();
            sc.nextLine();

            List<Order> oList = new ArrayList<>();

            for (int i = 1; i <= n; i++) {

                Order o1 = new Order();

                System.out.print("Enter Order Date: ");
                o1.setOrderDate(sc.next());

                System.out.print("Enter Amount: ");
                o1.setTotalAmount(sc.nextDouble());
                sc.nextLine();

                o1.setCustomer(c1);
                oList.add(o1);
            }

            c1.setOrderlist(oList);

            session.persist(c1);

            tr.commit();
            System.out.println("Customer Saved Successfully");

        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void getCustomer(Long id) {

        Session session = HibernateUtil.getSession();

        Customer c1 = session.get(Customer.class, id);

        if (c1 == null) {
            System.out.println("Customer Not Found");
            session.close();
            return;
        }

        System.out.println("ID: " + c1.getCustomerId());
        System.out.println("Name: " + c1.getName());
        System.out.println("Email: " + c1.getEmail());
        System.out.println("Phone: " + c1.getPhone());

        lead_cs lead = c1.getLeadid();
        if (lead != null) {
            System.out.println("Lead Source: " + lead.getSource());
            System.out.println("Lead Status: " + lead.getStatus());
        }

        List<Order> orders = c1.getOrderlist();
        if (orders != null) {
            for (Order o : orders) {
                System.out.println("Order Date: " + o.getOrderDate());
                System.out.println("Amount: " + o.getTotalAmount());
            }
        }

        session.close();
    }

    public void updateCustomer(Long id) {

        Session session = HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();

        try {

            Customer c1 = session.get(Customer.class, id);

            if (c1 == null) {
                System.out.println("Customer Not Found");
                return;
            }

            System.out.print("Enter new Name: ");
            c1.setName(sc.nextLine());

            System.out.print("Enter new Email: ");
            c1.setEmail(sc.next());

            System.out.print("Enter new Phone: ");
            c1.setPhone(sc.next());
            sc.nextLine();

            lead_cs lead = c1.getLeadid();

            System.out.print("Enter new Lead Source: ");
            lead.setSource(sc.next());

            System.out.print("Enter new Lead Status: ");
            lead.setStatus(sc.next());
            sc.nextLine();

            tr.commit();
            System.out.println("Customer Updated Successfully");

        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteCustomer(Long id) {

        Session session = HibernateUtil.getSession();
        Transaction tr = session.beginTransaction();

        try {

            Customer c1 = session.get(Customer.class, id);

            if (c1 == null) {
                System.out.println("Customer Not Found");
                return;
            }

            session.remove(c1);
            tr.commit();
            System.out.println("Customer Deleted Successfully");

        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void displayAllCustomers() {

        Session session = HibernateUtil.getSession();

        List<Customer> customers =
                session.createQuery("from Customer", Customer.class).list();

        if (customers.isEmpty()) {
            System.out.println("No Records Found");
            session.close();
            return;
        }

        for (Customer c : customers) {
            System.out.println("ID: " + c.getCustomerId());
            System.out.println("Name: " + c.getName());
            System.out.println("Email: " + c.getEmail());
            System.out.println("-------------------------");
        }

        session.close();
    }
}