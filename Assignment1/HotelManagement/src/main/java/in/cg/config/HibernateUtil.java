package in.cg.config;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.cg.entities.Booking;

public class HibernateUtil {

    private Session session;
    private Scanner sc;
    public int noOfDays(String checkIn,String checkOut) {
		String[] checkInDate = checkIn.split("-");
		String[] checkOutDate = checkOut.split("-");
		int checkInDay = Integer.parseInt(checkInDate[0]);
		int checkInMonth = Integer.parseInt(checkInDate[1]);
		int checkInYear = Integer.parseInt(checkInDate[2]);
		int checkOutDay = Integer.parseInt(checkOutDate[0]);
		int checkOutMonth = Integer.parseInt(checkOutDate[1]);
		int checkOutYear = Integer.parseInt(checkOutDate[2]);
		int noOfDays = 0;
		if(checkInYear == checkOutYear) {
			if(checkInMonth == checkOutMonth) {
				noOfDays = checkOutDay - checkInDay;
			}
			else {
				noOfDays = (checkOutMonth - checkInMonth) * 30 + (checkOutDay - checkInDay);
			}
		}
		else {
			noOfDays = (checkOutYear - checkInYear) * 365 + (checkOutMonth - checkInMonth) * 30 + (checkOutDay - checkInDay);
		}
		return noOfDays;
	}
    public HibernateUtil() {
        Configuration cfg = new Configuration();
        cfg.configure("in/cg/config/hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        session = sf.openSession();
        sc = new Scanner(System.in);
    }

    public void addData() throws InterruptedException {

        Booking b = new Booking();

        System.out.print("Enter Customer Name: ");
        b.setCustomerName(sc.nextLine());

        System.out.print("Enter Number for RoomType: "
        		+ "1: STANDARD (2000 per day), 2: DELUXE (3500 per day), 3: SUITE (5000 per day): ");
        int roomChoice = sc.nextInt();
        sc.nextLine();
        if (roomChoice == 1) {
			b.setRoomType("STANDARD");
		} else if (roomChoice == 2) {
			b.setRoomType("DELUXE");
		} else if (roomChoice == 3) {
			b.setRoomType("SUITE");
		} else {
			System.out.println("Invalid Room Type! Defaulting to STANDARD.");
			b.setRoomType("STANDARD");
		}
        System.out.print("Enter Check-In Date: ");
        b.setCheckInDate(sc.nextLine());

        System.out.print("Enter Check-Out Date: ");
        b.setCheckOutDate(sc.nextLine());

        System.out.print("Calculation Total Amount based on Room Type and Number of Days... ");
        Thread.sleep(2000);
        int days = noOfDays(b.getCheckInDate(), b.getCheckOutDate());
        double roomPrice = 0;
        if (b.getRoomType().equals("STANDARD")) {
        				roomPrice = 2000;
		} else if (b.getRoomType().equals("DELUXE")) {
			roomPrice = 3500;
		} else if (b.getRoomType().equals("SUITE")) {
			roomPrice = 5000;
        }
        double amount = days * roomPrice;
        b.setTotalAmount(amount);
        System.out.println("Total Amount: " + amount);
        Transaction tr = session.beginTransaction();
        try {
            session.persist(b);
            tr.commit();
            System.out.println("Booking Added Successfully!");
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public void updateData(int id) {

        Booking b = session.get(Booking.class, id);

        if (b == null) {
            System.out.println("No Booking found for ID: " + id);
            return;
        }

        System.out.println("Choose what to update:");
        System.out.println("1: Customer Name");
        System.out.println("2: Room Type");
        System.out.println("3: Check-In Date");
        System.out.println("4: Check-Out Date");
        System.out.println("5: Total Amount");
        System.out.println("Any other number: Exit");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter new Customer Name: ");
            b.setCustomerName(sc.nextLine());
        } else if (choice == 2) {
            System.out.print("Enter new Room Type: ");
            b.setRoomType(sc.nextLine());
        } else if (choice == 3) {
            System.out.print("Enter new Check-In Date: ");
            b.setCheckInDate(sc.nextLine());
        } else if (choice == 4) {
            System.out.print("Enter new Check-Out Date: ");
            b.setCheckOutDate(sc.nextLine());
        } else if (choice == 5) {
            System.out.print("Enter new Total Amount: ");
            b.setTotalAmount(sc.nextDouble());
            sc.nextLine();
        } else {
            System.out.println("Exiting update.");
            return;
        }

        Transaction tr = session.beginTransaction();
        try {
            session.merge(b);
            tr.commit();
            System.out.println("Booking Updated Successfully!");
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public void deleteData(int id) {

        Booking b = session.get(Booking.class, id);

        if (b == null) {
            System.out.println("No Booking found for ID: " + id);
            return;
        }

        Transaction tr = session.beginTransaction();
        try {
            session.remove(b);
            tr.commit();
            System.out.println("Booking Deleted Successfully!");
        } catch (Exception e) {
            tr.rollback();
            System.out.println("Deletion Failed: " + e.getMessage());
        }
    }

    public void displayRecordById(int id) {

        Booking b = session.get(Booking.class, id);

        if (b == null) {
            System.out.println("No Booking found for ID: " + id);
            return;
        }

        System.out.println("BookingId: " + b.getBookingId());
        System.out.println("CustomerName: " + b.getCustomerName());
        System.out.println("RoomType: " + b.getRoomType());
        System.out.println("CheckInDate: " + b.getCheckInDate());
        System.out.println("CheckOutDate: " + b.getCheckOutDate());
        System.out.println("TotalAmount: " + b.getTotalAmount());
    }

    public void displayAllRecord() {

        List<Booking> list = session.createQuery("from Booking", Booking.class).list();

        if (list.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking b : list) {
            System.out.println("--------------------------------");
            System.out.println("BookingId: " + b.getBookingId());
            System.out.println("CustomerName: " + b.getCustomerName());
            System.out.println("RoomType: " + b.getRoomType());
            System.out.println("CheckInDate: " + b.getCheckInDate());
            System.out.println("CheckOutDate: " + b.getCheckOutDate());
            System.out.println("TotalAmount: " + b.getTotalAmount());
        }
        System.out.println("--------------------------------");
    }

    public void close() {
        session.close();
    }
}