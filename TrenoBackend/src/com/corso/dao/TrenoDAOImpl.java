package com.corso.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.corso.dto.TrenoDTO;
import com.corso.treno.Treno;

@Component
public class TrenoDAOImpl extends BaseDAO implements TrenoDAO{

	public Integer create(TrenoDTO bean){
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
	   
	   
	   public void update(TrenoDTO bean ){
		   super.update(bean);
	   }
	   
	   public void delete(TrenoDTO bean ){
		    
		   super.delete(bean);
	   }


	@Override
	public TrenoDTO findById(Integer id) {
		return (TrenoDTO) super.find(Treno.class, id);
		
	}


	public List<Bean> findAll(){
		return super.findAll("TrenoDTO");
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

