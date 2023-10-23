package com.corso.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Transaction;


import java.util.List;

import org.hibernate.HibernateException;

public abstract class BaseDAO {

	protected static SessionFactory factory; 
	 
	 static {
	 try {
       factory = new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) { 
       System.err.println("Failed to create sessionFactory object." + ex);
       throw new ExceptionInInitializerError(ex); 
    }
	 }
	
	   protected Integer create(Bean bean){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer beanID = null;
	      
	      try {
	         tx = session.beginTransaction();
	         
	         beanID = (Integer) session.save(bean);
	         
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return beanID;
	   }
	   
	   
	   
	   protected void update(Bean bean){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.update(bean); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	    protected void delete(Bean bean){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         session.delete(bean); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	    
	    
//	    protected void deleteById(Class classe,int id){
//		      Session session = factory.openSession();
//		      Transaction tx = null;
//		      
//		      try {
//		          tx = session.beginTransaction();
//		          Bean bean = session.get(classe, id);
//		          if (treno != null) {
//		              // Per ogni vagono associato a un Treno, elimina l'istanza di Vagone
//		              for (Vagone vagone : treno.getTreno()) {
//		                  session.delete(vagone);
//		              }
//		              session.delete(treno);
//		          }
//
//		         
//		         tx.commit();
//		      } catch (HibernateException e) {
//		         if (tx!=null) tx.rollback();
//		         e.printStackTrace(); 
//		      } finally {
//		         session.close(); 
//		      }
//		   }
		    
	    
	    protected Bean find(Class classe, Integer id){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      Bean bean = null;
		      
		      try {
		         tx = session.beginTransaction();
		         
		         bean = (Bean) session.get(classe, id);
		         
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return bean;
		   } 
	    
	    
	    public List<Bean> findAll(String className) {
	        Session session = factory.openSession();
	        Transaction tx = null;
	        List<Bean> beanList = null;
	        try {
	            tx = session.beginTransaction();

	            String hql = "FROM " + className; // Usa il nome della classe dinamicamente
	            Query<Bean> query = session.createQuery(hql, Bean.class);

	            beanList = query.list();
	            tx.commit();
	        } catch (HibernateException e) {
	            if (tx != null) tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return beanList;
	    }
	    





}

