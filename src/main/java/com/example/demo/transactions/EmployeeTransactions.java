package com.example.demo.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class EmployeeTransactions {

	@Autowired
	EntityManager eManager;
	
	
	public Employee save(Employee e)
	{
		return eManager.merge(e);
	}
	
	public List<Employee> findAll()
	{
		 
		return eManager.createQuery("select e from Employee e",Employee.class).getResultList();
	}
	
	
	
	public Employee findByIdEmployee(int id)
	{
		Employee employee=eManager.find(Employee.class, id);
		
		return  employee;
	}
	
	public int deleteById(int id)
	{
		Employee employee=eManager.find(Employee.class, id);
		eManager.remove(employee);
		return id;		
		
	}
	
	public Employee updateEmployeeById(int id, Employee updatedEmployee) {
        Employee existingEmployee = eManager.find(Employee.class, id);
        Employee employee=new Employee();
        if (existingEmployee != null) {
            
        	// Perform updates on the existing entity
        	existingEmployee.setEname(updatedEmployee.getEname());
            existingEmployee.setSalary (updatedEmployee.getSalary());
            existingEmployee.setDeg(updatedEmployee.getDeg());
            employee=eManager.merge(existingEmployee);
        }
        
        return employee;
    }
	
}
