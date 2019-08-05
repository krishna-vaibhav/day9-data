package tester;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CustomerDaoImpl;
import pojos.Customer;
import pojos.CustomerType;

public class UnsubscribeCustomers {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf();) {
			System.out.println("sf created.....");
			System.out.println("Enter role");
			new CustomerDaoImpl().
			unsubscribeCustomer(sc.next()).
			forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
