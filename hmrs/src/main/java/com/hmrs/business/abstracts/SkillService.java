package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.entities.concretes.Skill;

public interface SkillService {
	Result add(Skill language);
	DataResult<List<Skill>> getAll();
	DataResult<List<Skill>> getAllByCvId(int cvId);
	DataResult<Skill> getById(int id);
}
