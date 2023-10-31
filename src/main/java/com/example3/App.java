package com.example3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example3.model.Address;
import com.example3.model.Customer;

public class App 
{
    public static void main( String[] args )
    { 
    	Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        try 
        {
        	Customer c1=new Customer();
           	c1.setName("Ramya");
           	
            Address a1=new Address();
            a1.setStreet("123 main str");
            a1.setCity("Hyd");
            a1.setCustomer(c1);
            	
            Address a2=new Address();
            a2.setStreet("456 main str");
            a2.setCity("medak");
            a2.setCustomer(c1);
            
            Customer c2=new Customer();
           	c2.setName("Ram");
           	
            Address a11=new Address();
            a11.setStreet("789 main str");
            a11.setCity("Pune");
            a11.setCustomer(c2);
            	
            Address a21=new Address();
            a21.setStreet("273 main str");
            a21.setCity("Chennai");
            a21.setCustomer(c2);
        	
            session.beginTransaction();
            session.save(c1);
            session.save(a1);
            session.save(a2);
            session.save(c2);
            session.save(a11);
            session.save(a21);
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally 
        {
        	session.close();
        	factory.close();
        }

    }
}


