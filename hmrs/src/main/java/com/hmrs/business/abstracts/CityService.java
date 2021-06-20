package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	DataResult<City> getById(int id);
}
