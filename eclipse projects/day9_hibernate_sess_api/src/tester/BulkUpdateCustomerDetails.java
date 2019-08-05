package tester;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CustomerDaoImpl;
import pojos.Customer;
import pojos.CustomerType;

public class BulkUpdateCustomerDetails {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf();) {
			System.out.println("sf created.....");
			System.out.println("Enter reg date n discount");
			System.out.println("Updated custs "
					+ new CustomerDaoImpl().bulkUpdateCustomerDetails(sdf.parse(sc.next()), sc.nextDouble()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
