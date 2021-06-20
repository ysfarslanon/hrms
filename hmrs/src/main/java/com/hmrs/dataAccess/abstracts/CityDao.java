package com.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{	
	
	City findById(int id);
	
}
