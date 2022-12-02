package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import pojo.com.hibernate.prueba.pojo.Animales;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Animales a1 =new Animales("Yorshire", "Casa", new BigDecimal(1));
		
		List animales = session.createQuery("FROM Animales").getResultList();
		
		for (Iterator i = animales.iterator(); i.hasNext(); ) {
			Animales a = (Animales) i.next();
			System.out.println(a.getNombre());
		}
		
		//session.save(a1);
		session.close();
	}

}
