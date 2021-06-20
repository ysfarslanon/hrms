package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.School;

public interface SchoolService {

	Result add(School school);
	DataResult<List<School>> getAll();
	DataResult<List<School>> getAllByCvId(int cvId);
	DataResult<List<School>> getAllByCvIdDesc(int cvId);
	DataResult<School> getById(int id);
}
