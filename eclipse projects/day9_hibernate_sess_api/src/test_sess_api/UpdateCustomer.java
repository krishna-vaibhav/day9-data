//user supplies --title & hib  updates price , if book title  exists
package test_sess_api;

import java.util.Scanner;

import org.hibernate.*;

import pojos.*;
import static utils.HibernateUtils.*;

public class UpdateCustomer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = getSf()) {
			System.out.println("Enter existing customer id");
			int id = sc.nextInt();
			Session session = sf.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Customer c1=session.get(Customer.class,id);//c1 --persistent
			tx.commit();
			System.out.println("Customer  Details " + c1);//c1 -- detached
			System.out.println("Enter reg amount inc");
			//updating state of detached pojo
			c1.setRegAmount(c1.getRegAmount()+sc.nextDouble());
			session = sf.getCurrentSession(); //new session
			tx = session.beginTransaction();
			System.out.println("session contains c1"+session.contains(c1));
			session.update(c1);//DETACHED ---> PERSISTENT
			System.out.println(session.contains(c1));
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
