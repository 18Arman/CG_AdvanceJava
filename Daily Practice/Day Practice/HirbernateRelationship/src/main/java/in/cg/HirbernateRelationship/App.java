package in.cg.HirbernateRelationship;

import java.util.Arrays;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import in.cg.entities.Course;
import in.cg.entities.Student; class App 
{
    public static void main( String[] args )
    {
        Configuration cfg=new Configuration();
        cfg.configure("/in/cg/config/hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s=sf.openSession();
        Transaction tr=s.beginTransaction();
        Course c1=new Course();
        c1.setName("JUnit");
        Course c2=new Course();
        c2.setName("Mockito");
        Student s1=new Student();
        s1.setName("Lakshmi");
        s1.setCourses(Arrays.asList(c1,c2));
        try {
        s.persist(s1);
        tr.commit();
        }
        catch(Exception e) {
        	tr.rollback();
        	System.out.println("Operation failed");
        }
    }
}
