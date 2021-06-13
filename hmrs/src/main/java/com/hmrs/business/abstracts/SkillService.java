package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.entities.concretes.Skill;

public interface SkillService {
	public Result add(Skill language);
	public DataResult<List<Skill>> getAll();
	public DataResult<List<Skill>> getAllByCvId(int cvId);
}
