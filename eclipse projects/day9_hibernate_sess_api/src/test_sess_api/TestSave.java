package test_sess_api;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Customer;
import pojos.CustomerType;

public class TestSave {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try (SessionFactory sf = getSf()) {
			System.out.println("sf created.....");
			// get session
			Session hs = sf.getCurrentSession();
			Transaction tx = hs.beginTransaction();
			System.out.println("Enter cust details nm em pass rol amt  date type");
			Customer c1 = new Customer("aa", "aa3@gmail", "12346","cust", 1500, new Date(), CustomerType.GOLD);
			c1.setId(124);
			System.out.println(c1);
			//c1--transient
			hs.saveOrUpdate(c1);//c1 --- persistent
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
