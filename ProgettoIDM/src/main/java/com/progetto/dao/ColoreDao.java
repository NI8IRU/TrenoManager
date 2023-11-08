package com.progetto.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.progetto.Colore;


@Component
public class ColoreDao {

	
	@Autowired
	SessionFactory factory;

	@Autowired
	HibernateTemplate hibernateTemplate;

	public Colore addColore(Colore colore) {
		hibernateTemplate.save(colore);
		return colore;
	}
	
//	@Transactional
//	public Colore addColore(Colore colore) {
//		if(findColoreByName(colore.getName()) == null) {
//			hibernateTemplate.save(colore);
//			return colore;
//		}else {
//			hibernateTemplate.save(colore);
//			return findColoreByName(colore.getName());
//		}
//		
//	}
//	
//	@Transactional
//	public Colore findColoreByName(String name) {
//	       Session session = factory.openSession();
//		      Transaction tx = null;
//		      Colore colore = null; 
//		      try {
//		         tx = session.beginTransaction();
//		         
//		         String hql = "from Colore where name = :name";
//		         Query<Colore> query = session.createQuery(hql, Colore.class);
//		         
//		         query.setParameter("name", name);
//		         
//		         
//		         colore = query.uniqueResult();
//		         tx.commit();
//		      } catch (HibernateException e) {
//		         if (tx!=null) tx.rollback();
//		         e.printStackTrace(); 
//		      } finally {
//		         session.close(); 
//		      }
//		      return colore;
//		   } 

}
