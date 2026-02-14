package in.cg.HotelManagement;
import java.util.Scanner;
import in.cg.config.HibernateUtil;
class App 
{
	
    public static void main( String[] args ) throws InterruptedException
    {
        HibernateUtil h = new HibernateUtil();
        Scanner sc=new Scanner(System.in);
        while(true) {
        	int choice=0;
        	System.out.println("1. Add Booking");
        	System.out.println("2. Update Booking");
        	System.out.println("3. Delete Booking");
        	System.out.println("4. View Booking");
        	System.out.println("5. View All Bookings");
        	System.out.println("6. Exit");
        	System.out.print("Enter your choice: ");
        	choice = sc.nextInt();
        	sc.nextLine();
        	switch(choice) {
	        	case 1:
					h.addData();
					break;
	        	case 2:
					System.out.print("Enter Booking ID to Update: ");
					int updateId = sc.nextInt();
					sc.nextLine();
					h.updateData(updateId);
					break;
				case 3:
					System.out.print("Enter Booking ID to Delete: ");
					int deleteId = sc.nextInt();
					sc.nextLine();
					h.deleteData(deleteId);
					break;
				case 4:
					System.out.print("Enter Booking ID to View: ");
					int viewId = sc.nextInt();
					sc.nextLine();
					h.displayRecordById(viewId);
					break;
				case 5:
					System.out.println("Displaying All Bookings...");
					h.displayAllRecord();
					break;
				case 6:
					System.out.println("Exiting...");
					sc.close();	
					break;
				default:
					System.out.println("Invalid Choice! Please try again.");
        	}
        	if(choice == 6) {
				break;
			}
        }
    }
}
