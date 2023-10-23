package com.corso.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.corso.treno.Treno;


public class TrenoDAOImpl extends BaseDAO implements TrenoDAO{

	public Integer create(Treno bean){
		   return super.create(bean);
	   }
	 
	   
	   public Integer create2(Object bean){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      Integer employeeID = null;
		      
		      try {
		         tx = session.beginTransaction();
		         
		         employeeID = (Integer) session.save(bean);
		         
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return employeeID;
		   }
	   
	   
	   public void update(Treno bean ){
		   super.update(bean);
	   }
	   
	   public void delete(Treno bean ){
		    
		   super.delete(bean);
	   }


	@Override
	public Treno findById(Integer id) {
		return (Treno) super.find(Treno.class, id);
		
	}


	

//	   public void deleteById(int id) {
//		   super.deleteById(id);
//	   }
//	@Override
//	public Treno find(Integer id) {
//		
//		return (Employee)super.find(Employee.class,id);
//	}	




	
}

