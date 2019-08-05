package test_sess_api;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Customer;
import pojos.CustomerType;

public class TestPersist {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try (SessionFactory sf = getSf()) {
			System.out.println("sf created.....");
			// get session
			Session hs = sf.getCurrentSession();
			Transaction tx = hs.beginTransaction();
			System.out.println("Enter cust details nm em pass rol amt  date type");
			Customer c1 = new Customer("aa", "aa2@gmail", "1234","cust", 500, new Date(), CustomerType.GOLD);
			c1.setId(123);
			System.out.println(c1);
			hs.persist(c1);
			System.out.println(c1.getId());
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
