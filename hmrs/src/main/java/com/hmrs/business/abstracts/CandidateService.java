package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.Candidate;

public interface CandidateService {
	Result add(Candidate candidate);
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int id);
	

}
