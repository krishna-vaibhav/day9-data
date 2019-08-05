package dao;

import pojos.Customer;
import org.hibernate.*;
import static utils.HibernateUtils.*;

import java.util.Date;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public String registerCustomer(Customer c) {
		// c ---TRANSIENT
		Integer id = null;
		// get session from SF
		Session hibSess = getSf().openSession();
		// begin tx
		Transaction tx = hibSess.beginTransaction();
		try {
			id = (Integer) hibSess.save(c); // PERSISTENT
			System.out.println("Press enter to continue");
			System.in.read();
			tx.commit(); // insert row --gains DB identity
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			// throw e;
		} finally {
			if (hibSess != null)
				hibSess.close();// cn rets to dn cn pool,l1 cache cleared
		}
		// c
		return "Customer reged  " + c;// DETACHED
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer c = null;
		// HS
		Session hs = getSf().openSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			c = hs.get(Customer.class, id); // c -- PERSISTENT
			c = hs.get(Customer.class, id);
			c = hs.get(Customer.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (hs != null)
				hs.close();
		}
		return c; // DETACHED
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> l1 = null;
		// HS
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery("select c from Customer c", Customer.class).getResultList(); // l1
																								// ---
																								// list
																								// of
																								// PERSISTENT
																								// pojos
			tx.commit();// detached
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;// l1 --- list of DETACHED pojos
	}

	@Override
	public List<Customer> getSelectedCustomers(Date d1, double amt) {
		List<Customer> l1 = null;
		String jpql = "select c from Customer c where c.regDate < :dt and c.regAmount > :amt1";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();

		try {
			l1 = hs.createQuery(jpql, Customer.class).setParameter("dt", d1).setParameter("amt1", amt).getResultList();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

	@Override
	public List<Customer> updateCustomerDetails(Date d1, double discount) {
		String status = "Customer updation failed";
		String jpql = "select c from Customer c where c.regDate < :dt";
		List<Customer> l1 = null;
		// HS
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Customer.class).setParameter("dt", d1).getResultList();
			// l1 --- list of PERSISTENT pojos
			for (Customer c : l1)
				c.setRegAmount(c.getRegAmount() - discount);
			for (Customer c : l1)
				c.setRegAmount(c.getRegAmount() - discount);

			tx.commit(); // update query fired auto for auto dirty checking
			status = "Customer details updated ....";
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		for (Customer c : l1)
			c.setRegAmount(c.getRegAmount() - discount);
		return l1;
	}

	@Override
	public int bulkUpdateCustomerDetails(Date d1, double discount) {
		int updateCount = 0;
		String jpql = "update Customer c set c.regAmount=c.regAmount-:amt where c.regDate < :dt";
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();

		try {
			updateCount = hs.createQuery(jpql).setParameter("amt", discount).setParameter("dt", d1).executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return updateCount;
	}

	@Override
	public List<Customer> unsubscribeCustomer(String role2) {
		String jpql = "select c from Customer c where c.role=:role1";
		List<Customer> l1 = null;
		Session hs = getSf().getCurrentSession();
		Transaction tx = hs.beginTransaction();
		try {
			l1 = hs.createQuery(jpql, Customer.class).
					setParameter("role1", role2).getResultList();
			//l1 --list of persistent entities
			for(Customer c : l1)
				hs.delete(c);//part of l1 cache --marked for removal
			tx.commit();//delete query,l1 cleared,sess close, cn reted to the pool
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return l1;
	}

}
