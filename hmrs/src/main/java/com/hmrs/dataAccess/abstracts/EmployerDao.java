package com.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{
	
	Employer findByEmailAddress(String mail);

}
