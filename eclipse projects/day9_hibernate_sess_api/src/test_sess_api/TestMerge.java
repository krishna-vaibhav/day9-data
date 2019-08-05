package test_sess_api;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.Customer;
import pojos.CustomerType;

public class TestMerge {

	public static void main(String[] args) {
	
		try (SessionFactory sf = getSf()) {
			System.out.println("sf created.....");
			// get session
			Session hs = sf.getCurrentSession();
			Transaction tx = hs.beginTransaction();
			System.out.println("Enter cust details nm em pass rol amt  date type");
			Customer c1 = new Customer("aa", "aa44@gmail", "4567","cust", 500, new Date(), CustomerType.SILVER);
			c1.setId(145);
			System.out.println(c1);
			Customer c2=(Customer)hs.merge(c1);
			System.out.println("after merge "+c1.getId());
			System.out.println("after merge "+c2.getId());
			System.out.println("both same "+(c1==c2));
			System.out.println("c1 present in l1 cache "+hs.contains(c1));
			System.out.println("c2 present in l1 cache "+hs.contains(c2));
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
