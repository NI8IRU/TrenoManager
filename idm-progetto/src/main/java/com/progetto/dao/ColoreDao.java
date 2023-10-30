package com.progetto.dao;

import java.awt.Color;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
	
//	@Transactional
//	public Colore addColore(Colore colore) {
//		if(findColoreByRgb(colore.getC()) == null) {
//			hibernateTemplate.save(colore);
//			return colore;
//		}else {
//			return findColoreByRgb(colore.getC());
//		}
//		
//	}
	
	@Transactional
	public Colore addColore(Colore colore) {
		if(findColoreByRgb(colore.getC()) == null) {
			hibernateTemplate.save(colore);
			return colore;
		}else {
			hibernateTemplate.save(colore);
			return findColoreByRgb(colore.getC());
		}
		
	}
	
	@Transactional
	public Colore findColoreByRgb(java.awt.Color c) {
	       Session session = factory.openSession();
		      Transaction tx = null;
		      Colore colore = null; 
		      try {
		         tx = session.beginTransaction();
		         
		         String hql = "from Colore where c = :c";
		         Query<Colore> query = session.createQuery(hql, Colore.class);
		         
		         query.setParameter("c", c);
		         
		         
		         colore = query.uniqueResult();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return colore;
		   } 

}
