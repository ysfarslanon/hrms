package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.entities.concretes.Candidate;

public interface CandidateService {
	void add(Candidate candidate);
	List<Candidate> getAll();
	

}
