package com.lpu.TestMaven.main;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.lpu.TestMaven.entities.AadharNo;
import com.lpu.TestMaven.entities.Person;
import com.lpu.TestMaven.entities.User;
public class App 
{
    public static void main( String[] args )
    { 
    	Configuration cf=new Configuration();
    	cf.configure("com/lpu/TestMaven/config/hibernate.cfg.xml");
        SessionFactory sf=cf.buildSessionFactory();
        Session s=sf.openSession();
        Transaction tr=s.beginTransaction();
        
        AadharNo aNo=new AadharNo();
        aNo.setNumber("122142134213423");
        Person p=new Person();
        p.setAadhar(aNo);
        p.setName("Harman");
        
        try {
        	s.persist(p);
        	tr.commit();
        	System.out.println("Data added successfully");
        }
        catch(Exception e) {
        	tr.rollback();
        	System.out.println(e.getMessage());
        }
        finally {
        	sf.close();
        }
        
//        //Insertion Operation
//        User u1=new User();
//        u1.setId(2L);
//        u1.setName("Ding Dong");
//        u1.setEmail("dingding@gmail.com");
//        u1.setGender("female");
//        u1.setCity("Mumbai");
//        try {
//        	s.persist(u1);
//        	tr.commit();
//        	System.out.println("User added Successfully");
//        }
//        catch(Exception e) {
//        	tr.rollback();
//        	e.printStackTrace();
//        	System.out.println("User Not Added");
//        }
        
        
        
// Updation
//        try {
//        	User u=s.get(User.class, 1L);
//        	if(u!=null) {
//        		System.out.println(u.getId());
//        		System.out.println(u.getName());
//        		System.out.println(u.getEmail());
//        		System.out.println(u.getCity());
//        		System.out.println(u.getGender());
//        		System.out.println(u.getClass());
//        	}
//        	else {
//        		System.out.println("User Not Found");
//        	}
//        }
//        catch(Exception e) {
//        	e.printStackTrace();
//        }
//        //Updation
//        User u2=s.get(User.class, 2L);
//        u2.setCity("Hyderabad");
//        try {
//        	s.saveOrUpdate(u2);
//        	tr.commit();
//        	System.out.println("Data updated Successfully");
//        }catch(Exception e) {
//        	tr.rollback();
//        }
//        
//        //Deletion
//        try {
//        	User user4=s.get(User.class,2L);
//        	s.remove(user4);
//        	System.out.println("deleted user");
//        }
//        finally {
//        	System.out.println("In finaly block");
//        }
    }
}