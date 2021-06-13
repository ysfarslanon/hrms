package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.School;

public interface SchoolService {

	public Result add(School school);
	public DataResult<List<School>> getAll();
	public DataResult<List<School>> getAllByCvId(int cvId);
	public DataResult<List<School>> getAllByCvIdDesc(int cvId);
	
}
