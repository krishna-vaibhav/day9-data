package test_sess_api;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Customer;
import pojos.CustomerType;

public class TestEvict {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {
			System.out.println("sf created.....");
			// get session
			Session hs = sf.getCurrentSession();
			Transaction tx = hs.beginTransaction();
			System.out.println("Enter cust id");
			Customer c=hs.get(Customer.class,14);//c -- PERSISTENT
	//		c.setRegAmount(c.getRegAmount()+100);//modifying state of persistent entity
			hs.delete(c);
			hs.clear(); 
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
