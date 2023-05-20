package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.transactions.EmployeeTransactions;

@RestController
@CrossOrigin(origins = "*")
public class HelloController {
	@Autowired
    private EmployeeTransactions empRepository;
	
	@GetMapping(path="/")  
	public String hello()
	{
		return "<h1>This is Get Request</h1>";
	}
	
	@PostMapping(path="/")
	public String hello2()
	{
		return "<h1>This is Post Request</h1>";
	}
	
	@GetMapping(path="/employees")
	public List<Employee> getAllEmployees()
	{
		
		return empRepository.findAll();
	}
	@DeleteMapping("/deleteEmp/{eid}")
	public int deleteById(@PathVariable int eid)
	{
		return empRepository.deleteById(eid);
	}
	@PostMapping("/updateEmployee/{eid}")
	public Employee updateEmployee(@PathVariable int eid,@RequestBody Employee emp)
	{
		return empRepository.updateEmployeeById(eid, emp);
	}
	
	@PostMapping("/addEmployee")
    public Employee createRecord(@RequestBody Employee emp) {
        return empRepository.save(emp);
    }
	
	@GetMapping("/findEmpById/{eid}")
	public Employee findById(@PathVariable int eid)
	{
	   return empRepository.findByIdEmployee(eid);	
	}
	
	

}
