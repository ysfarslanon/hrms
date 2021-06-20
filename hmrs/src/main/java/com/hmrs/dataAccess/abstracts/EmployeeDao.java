package com.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{
	
	Employee findById(int id);
	

}
