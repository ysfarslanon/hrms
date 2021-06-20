package com.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image,Integer>{
	
	Image findById(int id);
	List<Image> findByCv_Id(int cvId);
	
}
