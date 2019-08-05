package tester;

import static utils.HibernateUtils.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestCurrentSession {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf()) {
			System.out.println("sf created.....");
			// get session
			Session hs1 = sf.getCurrentSession();
			Session hs2 = sf.getCurrentSession();
			Session hs3 = sf.getCurrentSession();
			System.out.println(hs1 == hs2);
			System.out.println(hs1 == hs3);
			Transaction tx = hs1.beginTransaction();
			System.out.println("is connected " + hs1.isConnected() + " is open " + hs1.isOpen());
			tx.commit();
			System.out.println("is connected " + hs1.isConnected() + " is open " + hs1.isOpen());
			hs1.close();
			System.out.println("is connected " + hs1.isConnected() + " is open " + hs1.isOpen());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
