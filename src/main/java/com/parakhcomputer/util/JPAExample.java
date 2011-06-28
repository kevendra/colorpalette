package com.parakhcomputer.util;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAExample {

	public void countExample(){
	    EntityManagerFactory emf=Persistence.
	    createEntityManagerFactory("jpa");
	        EntityManager em=emf.createEntityManager();
	        try{
	          EntityTransaction entr=em.getTransaction();
	          entr.begin();
	          Query query=em.createQuery("SELECT COUNT	    (emp.empName) FROM Employee emp");
	          Number cResults=(Number) query.getSingleResult();
	          System.out.println("Total Count result = "	    +cResults);
	          entr.commit();
	        }
	        finally{
	          em.close();
	        }
	}
	  public static void groupBy() {
		    
		    EntityManagerFactory emf=Persistence.		createEntityManagerFactory("jpa");
		    EntityManager em=emf.createEntityManager();
		    try{
		      EntityTransaction entr=em.getTransaction();
		      entr.begin();
		      Query query=em.createQuery("SELECT emp FROM		Employee emp group by emp.empSalary");
		      List list=query.getResultList();
//		      Iterator<Employee> itr=list.iterator();
//		      while(itr.hasNext()){
//		    	  Employee emp=itr.next();
//		        System.out.print("Emp Name:"+emp.getEmpName());
//		        System.out.print(" Salary:"+ emp.getEmpSalary());
//		        System.out.println();
//		      }
		      entr.commit();
		    }
		    finally{
		      em.close();
		    }	
	  }
}
