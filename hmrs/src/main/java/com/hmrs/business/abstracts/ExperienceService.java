package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.Experience;

public interface ExperienceService {
	public Result add(Experience experience);
	public DataResult<List<Experience>> getAll();
	public DataResult<List<Experience>> getAllByCvId(int cvId);
	public DataResult<List<Experience>> getAllByCvIdDesc(int cvId);
}
