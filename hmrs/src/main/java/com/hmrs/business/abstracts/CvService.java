package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.entities.concretes.Cv;

public interface CvService {

	public Result add(Cv cv);
	public DataResult<List<Cv>> getAll();
	public DataResult<List<Cv>> getAllByCandidateId(int candidateId);
	public DataResult<Cv> getById(int cvId);
}
