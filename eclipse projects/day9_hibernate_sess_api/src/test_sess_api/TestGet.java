package test_sess_api;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Customer;
import pojos.CustomerType;

public class TestGet {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {
			System.out.println("sf created.....");
			// get session
			Session hs = sf.getCurrentSession();
			Transaction tx = hs.beginTransaction();
			System.out.println("Enter cust id");
			Customer c = hs.load(Customer.class, 140);// c--- persistent
			System.out.println(c.getEmail());
			tx.commit();
			// c ---detached
			System.out.println(c.getClass().getName());
			System.out.println("details " + c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
