package com.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer>{
	JobTitle findByTitle(String title);//field name
	

}
