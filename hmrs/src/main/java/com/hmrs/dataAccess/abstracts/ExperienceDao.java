package com.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.Experience;;

public interface ExperienceDao extends JpaRepository<Experience,Integer>{
	
	List<Experience> findAllByCv_Id(int cvId);
	List<Experience> findAllByCv_IdOrderByEndDateDesc(int cvId);
	Experience findById(int id);
	
}
