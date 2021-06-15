package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.CvService;
import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.core.utilities.result.SuccessDataResult;
import com.hmrs.core.utilities.result.SuccessResult;
import com.hmrs.dataAccess.abstracts.CvDao;
import com.hmrs.entities.concretes.Cv;

@Service
public class CvManager implements CvService{

	private CvDao cvDao;
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv eklendi");
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Cv listesi getirildi.");
	}

	@Override
	public DataResult<List<Cv>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAllByCandidate_Id(candidateId), "Aday cvleri getirildi");
	}

	@Override
	public DataResult<Cv> getById(int cvId) {
		return new SuccessDataResult<Cv>(this.cvDao.findById(cvId), "Cv Getirildi.");
	}

}
