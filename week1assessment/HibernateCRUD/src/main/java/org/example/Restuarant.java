package org.example;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;
import java.util.Scanner;
import org.example.entity.*;
import java.util.List;
public class Restuarant {
	private static SessionFactory sessionfactory;
	static {
		try {
			sessionfactory=new Configuration().configure().buildSessionFactory();
			
		}catch(Exception e) {
			System.out.println("SEssionFacotryr cannot be made, error came");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1->add to menu\n2->see menu\n3.update price\n4.delete item from menu\n5.stop");
			System.out.println("giev you choice to do: ");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				Session session=sessionfactory.openSession();
				Transaction tnx=session.beginTransaction();
				System.out.println("Enter item toadd: ");
				String name=sc.nextLine();
				System.out.println("Enter price: ");
				double price=sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter category: ");
				String category=sc.nextLine();
				System.out.println("Aviable or not: ");
				boolean available=sc.nextBoolean();
				MenuItem m=new MenuItem(name, price, category, available);
				session.save(m);
				tnx.commit();
				session.close();
				System.out.println("item is added");
				break;
			case 2:
				Session session2=sessionfactory.openSession();
				List<MenuItem> list=session2.createQuery("from MenuItem", MenuItem.class).list();
				for(MenuItem i: list) {
					System.out.println("ID: "+i.getId()+"Name: "+i.getName()+"Price: "+i.getPrice()+"Category: "+i.getCategory()+"aviable: "+i.isAvailable());
				}
				session2.close();
				break;
			case 3:
				Session session3=sessionfactory.openSession();
				Transaction tnx1=session3.beginTransaction();
				System.out.println("Enter id where shoudl be updated: ");
				int upid=sc.nextInt();
				sc.nextLine();
				MenuItem item=session3.get(MenuItem.class, upid);
				if(item!=null) {
					System.out.println("Enter new price: ");
					double pr=sc.nextDouble();
					item.setPrice(pr);
					session3.update(item);
					System.out.println("item price is updated");
				}else {
					System.out.println("item id u gave is not found");
				}
				tnx1.commit();
				session3.close();
				break;
			case 4:
				Session session4=sessionfactory.openSession();
				Transaction txn2=session4.beginTransaction();
				System.out.println("Enter id to delete: ");
				int did=sc.nextInt();
				sc.nextLine();
				MenuItem i=session4.get(MenuItem.class, did);
				if(i!=null) {
					session4.delete(i);
					System.out.println("item is deleted");
				}else {
					System.out.println("item is not found");
				}
				txn2.commit();
				session4.close();
				break;
			case 5:
				sessionfactory.close();
				sc.close();
				System.out.println("Everthing done bye bye");
				return;
			default:
				System.out.println("Invalid choice u gave");
			}
		}
	}

}
