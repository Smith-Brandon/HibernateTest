package hibernate_package;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		String fName;
		String lName;
		String pass;
		
		User user = new User();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your first name");
		fName = scanner.nextLine();
		System.out.println("Please enter your last name");
		lName = scanner.nextLine();
		System.out.println("Please enter your password");
		pass = scanner.nextLine();
		
		scanner.close();
		user.setfirstName(fName);
		user.setlastName(lName);
		user.setpassword(pass);

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		
	}

}
