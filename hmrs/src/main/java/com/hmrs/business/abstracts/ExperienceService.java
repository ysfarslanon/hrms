package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experience);
	DataResult<List<Experience>> getAll();
	DataResult<List<Experience>> getAllByCvId(int cvId);
	DataResult<List<Experience>> getAllByCvIdDesc(int cvId);
	DataResult<Experience> getById(int id);
}
