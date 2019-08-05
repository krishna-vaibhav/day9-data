package tester;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CustomerDaoImpl;
import pojos.Customer;
import pojos.CustomerType;

public class GetAllCustomerDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf();) {
			System.out.println("sf created.....");
			new CustomerDaoImpl().
			getAllCustomers().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
