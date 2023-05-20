package com.example.demo;

import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Employee;
import com.example.demo.transactions.EmployeeTransactions;



@SpringBootApplication
public class RestfulWebServices6Application implements CommandLineRunner {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EmployeeTransactions empTrans;
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServices6Application.class, args);
		
		
		
	}
	

	public RestfulWebServices6Application(EmployeeTransactions empTrans) {
		super();
		this.empTrans = empTrans;
	}


	@Override
	public void run(String... args) throws Exception {
		
		empTrans.save(new Employee(1, "Ramesh",45000.0,"Manager"));
		empTrans.save(new Employee(2, "Akash",20000.0,"Web Designer"));
		empTrans.save(new Employee(3, "Salman",65000.0,"Wordpress Developer"));
		
	 Employee e=empTrans.findByIdEmployee(2);
	 logger.info("Employee->{}",e);
	 
	 
	// empTrans.deleteById(2);
	 
	 
		
	
		
	}

}
