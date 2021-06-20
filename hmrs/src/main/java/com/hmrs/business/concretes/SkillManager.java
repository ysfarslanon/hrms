package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.SkillService;
import com.hmrs.core.utilities.result.*;
import com.hmrs.dataAccess.abstracts.SkillDao;
import com.hmrs.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{

	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	
	@Override
	public Result add(Skill language) {
		this.skillDao.save(language);
		return new SuccessResult("Yetenek eklendi");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(), "Yetenekler listelendi");
	}

	@Override
	public DataResult<List<Skill>> getAllByCvId(int cvId) {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAllByCv_Id(cvId), "CV yetenekleri listelendi");
	}
	
	@Override
	public DataResult<Skill> getById(int id) {
		return new SuccessDataResult<Skill>(this.skillDao.findById(id), "Yetenek listelendi.");
	}

}
