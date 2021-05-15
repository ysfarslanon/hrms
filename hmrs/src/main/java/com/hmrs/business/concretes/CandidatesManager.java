package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.CandidateService;
import com.hmrs.dataAccess.abstracts.CandidateDao;
import com.hmrs.entities.concretes.Candidate;

@Service
public class CandidatesManager implements CandidateService{
	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidatesManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public void add(Candidate candidate) {
		this.candidateDao.save(candidate);
		
	}

	@Override
	public List<Candidate> getAll() {
		return this.candidateDao.findAll();
	}
	
	

}
