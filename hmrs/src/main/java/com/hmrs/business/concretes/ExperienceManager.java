package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.ExperienceService;
import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.core.utilities.result.SuccessDataResult;
import com.hmrs.core.utilities.result.SuccessResult;
import com.hmrs.dataAccess.abstracts.ExperienceDao;
import com.hmrs.dataAccess.abstracts.SkillDao;
import com.hmrs.entities.concretes.Experience;
import com.hmrs.entities.concretes.Skill;

@Service
public class ExperienceManager implements ExperienceService{

	
private SkillDao skillDao;
	
	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	
	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Deneyim eklendi");
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(), "Deneyimler listelendi");
	}

	@Override
	public DataResult<List<Experience>> getAllByCvId(int cvId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAllByCv_Id(cvId), "CV deneyimleri listelendi");
	}

	@Override
	public DataResult<List<Experience>> getAllByCvIdDesc(int cvId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAllByCv_IdOrderByEndDateDesc(cvId), "CV deneyimleri listelendi");
	}
	

}
