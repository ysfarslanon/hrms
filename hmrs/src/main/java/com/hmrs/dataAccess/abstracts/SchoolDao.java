package com.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

	List<School> findAllByCv_Id(int cvId);
	List<School> findAllByCv_IdOrderByEndDateDesc(int cvId);
	School findById(int id);
	
}
