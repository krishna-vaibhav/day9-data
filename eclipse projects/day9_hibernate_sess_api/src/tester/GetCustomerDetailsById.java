package tester;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CustomerDaoImpl;
import pojos.Customer;
import pojos.CustomerType;

public class GetCustomerDetailsById {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf();) {
			System.out.println("sf created.....");
			System.out.println("Enter cust id");
			System.out.println(new CustomerDaoImpl().getCustomerById(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
