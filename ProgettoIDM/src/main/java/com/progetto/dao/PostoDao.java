package com.progetto.dao;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.progetto.vagoni.PostoASedere;

@Component
public class PostoDao {
	
	@Autowired
	SessionFactory factory;

	@Autowired
	HibernateTemplate hibernateTemplate;
	
//	@Transactional
//	public void OccupaPostoById(Long id) {
//		PostoASedere posto = findPostoById(id);
//		posto.occupaPosto();
//		hibernateTemplate.update(posto);
//	}

	
	public PostoASedere findPostoById(Long id) {
		Session session = factory.openSession();
	      Transaction tx = null;
	      PostoASedere posto = null; 
	      try {
	         tx = session.beginTransaction();
	         
	         String hql = "from PostoASedere where id = :id";
	         Query<PostoASedere> query = session.createQuery(hql, PostoASedere.class);
	         
	         query.setParameter("id", id);
	         
	         
	         posto = query.uniqueResult();
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return posto;
			  
	}
}
