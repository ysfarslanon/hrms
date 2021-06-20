package com.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hmrs.business.abstracts.CityService;
import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.SuccessResult;
import com.hmrs.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	private CityService cityService;
	
	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService=cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getall(){
		return this.cityService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<City> getById(@RequestParam int id){
		return this.cityService.getById(id);
	}
}
