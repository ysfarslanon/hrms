package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.SchoolService;
import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.core.utilities.result.SuccessDataResult;
import com.hmrs.core.utilities.result.SuccessResult;
import com.hmrs.dataAccess.abstracts.SchoolDao;
import com.hmrs.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul eklendi");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(), "Okullar listelendi");
	}

	@Override
	public DataResult<List<School>> getAllByCvId(int cvId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByCv_Id(cvId), "Cv okullari listelendi");
	}

	@Override
	public DataResult<List<School>> getAllByCvIdDesc(int cvId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByCv_IdOrderByEndDateDesc(cvId), "Cv okulları listelendi");
	}

}
