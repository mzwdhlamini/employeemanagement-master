package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.EmployeeEntity;

/**
 * Session Bean implementation class EmployeeEJB
 */
@Stateless // sync or async-- stateless is one we should use.
@LocalBean

public class EmployeeEJB {


	@PersistenceContext  // only if there is only one persistence-unit name
	private EntityManager em;  //------------------------- this links to DB
	
    public EmployeeEJB() {
        // TODO Auto-generated constructor stub
    }
    
       
    public void addNew(EmployeeEntity employeeEntity)
    {
    	System.out.println("============================");
    	System.out.println(employeeEntity.getName());
    	em.persist(employeeEntity); //-------------------------this saves to DB                 
    	System.out.println("============================");
    	
    }
    
    public EmployeeEntity showEmployee(EmployeeEntity employeeEntity)
    {
    	
    	  PersistenceUtil util = Persistence.getPersistenceUtil();
    	  boolean isObjectLoaded = util.isLoaded(employeeEntity);
    	  boolean isFieldLoaded = util.isLoaded(employeeEntity, 1);
    	
    	  if (isFieldLoaded) {
    		  
    		  System.out.println("============================");
    		  Employee employee = em.find(EmployeeEntity.class, 1); //-------------------------this retrieves from  DB
    		  System.out.println("============================");
    	  }	
    	
    }
    
}
