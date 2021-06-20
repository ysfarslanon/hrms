package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.CityService;
import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.SuccessDataResult;
import com.hmrs.dataAccess.abstracts.CityDao;
import com.hmrs.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao=cityDao;
	}
	
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult(this.cityDao.findAll(), "Şehirler Listelendi");
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(this.cityDao.findById(id), "Şehir getirildi.");
	}
	
	

}
