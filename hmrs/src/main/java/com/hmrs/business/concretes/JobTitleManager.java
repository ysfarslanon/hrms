package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.JobTitleService;
import com.hmrs.dataAccess.abstracts.JobTitleDao;
import com.hmrs.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleDao jobtitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobtitleDao) {
		super();
		this.jobtitleDao = jobtitleDao;
	}

	@Override
	public void add(JobTitle jobTitle) {
		this.jobtitleDao.save(jobTitle);
	}

	@Override
	public List<JobTitle> getAll() {
		return this.jobtitleDao.findAll();
	}

}
