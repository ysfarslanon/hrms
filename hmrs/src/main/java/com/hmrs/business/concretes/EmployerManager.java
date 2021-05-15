package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.EmployerService;
import com.hmrs.dataAccess.abstracts.EmployerDao;
import com.hmrs.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public void add(Employer employer) {
		this.employerDao.save(employer);
		
	}

	@Override
	public List<Employer> getAll() {		
		return this.employerDao.findAll();
	}

}
