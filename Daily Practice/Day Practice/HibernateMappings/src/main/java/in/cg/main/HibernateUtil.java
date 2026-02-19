package in.cg.main;
import java.util.Scanner;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import in.cg.entities.Profile;
import in.cg.entities.User;
public class HibernateUtil {
	Session session;
	Scanner sc;
	HibernateUtil(){
		Configuration cfg=new Configuration();
		cfg.configure("in/cg/config/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		session=sf.openSession();
		sc=new Scanner(System.in);
	}
	void addData() {
		System.out.println("UserDetails:");
		System.out.print("Enter Name: ");
		String name=sc.nextLine();
		System.out.println("ProfileDetails");
		System.out.print("Enter ProfileNumber:");
		String pNum=sc.nextLine();
		Profile pObj=new Profile();
		pObj.setProfileNo(pNum);
		User uObj=new User();
		uObj.setName(name);
		//Uni Directional Mapping
		uObj.setPno(pObj);
		//Bi-Directional Mapping
		pObj.setuObj(uObj);
		Transaction tr=session.beginTransaction();
		try {
			session.persist(uObj);
			tr.commit();
		}
		catch(Exception e){
			tr.rollback();
			System.out.println(e.getMessage());
		}
	}
	void updateData(int id) {
		User ob=session.get(User.class, id);
		if(ob==null) {
			System.out.println("No Entry for this ID in database: "+id);
			return;
		}
		System.out.println("Enter digits for choosing column:"
				+ "1: UserName"
				+ "2: ProfileNumber"
				+"any other number to exit this.");
		int choice=sc.nextInt();
		sc.nextLine();
		if(choice==1) {
			System.out.print("Enter userName: ");
			ob.setName(sc.nextLine());
		}
		else if(choice==2) {
			System.out.print("Enter ProfileNumber: ");
			ob.getPno().setProfileNo(sc.nextLine());
		}
		else {
			System.out.println("Exiting");
			return;
		}
		Transaction tr=session.beginTransaction();
		try {
			session.persist(ob);
			tr.commit();
			System.out.println("Data updated Successfully!");
		}
		catch(Exception e){
			tr.rollback();
			System.out.println(e.getMessage());
		}
	}
	void deleteData(int id) {
		User ob=session.get(User.class, id);
		if(ob==null) {
			System.out.println("No Entry for this ID in database: "+id);
			return;
		}
		Transaction tr=session.beginTransaction();
		try {
			session.remove(ob);
			tr.commit();
			System.out.println("Data Deleted Successfully");
		}
		catch(Exception e){
			tr.rollback();
			System.out.println("Deletion Failed"+e.getMessage());
		}
	}
	void displayRecordById(int id) {
		User ob=session.get(User.class, id);
		if(ob==null) {
			System.out.println("No Entry for this ID in database: "+id);
			return;
		}
		Transaction tr=session.beginTransaction();
		try{
			session.remove(ob);
			tr.commit();
			System.out.println("Data Deleted Successfully");
		}
		catch(Exception e){
			tr.rollback();
			System.out.println("Fetching Failed"+e.getMessage());
		}
	}
	void displayAllRecord() {
		List<>
	}
}