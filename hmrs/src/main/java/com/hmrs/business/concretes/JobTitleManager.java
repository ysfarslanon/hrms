package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.JobTitleService;
import com.hmrs.core.utilities.result.*;
import com.hmrs.dataAccess.abstracts.JobTitleDao;
import com.hmrs.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobtitleDao) {
		super();
		this.jobTitleDao = jobtitleDao;
	}

	@Override
	public Result add(JobTitle jobTitle) {	
		if (jobTitle.getTitle().isEmpty()) {
			return new ErrorResult("İş pozisyonu boş bırakılamaz.");
		}
		if (isExistJobTitle(jobTitle.getTitle())) {
			return new ErrorResult("Daha önce var olan bir pozisyon ekleyemezsiniz.");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Eklendi");
	}
	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"İş pozisyonları getirildi.");
	}
	
	@Override
	public DataResult<JobTitle> getById(int id) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.findById(id),"İş pozisyonu getirildi.");
	}
	
	//--------BUSİNESS RULES-------
	private boolean isExistJobTitle(String jobTitle) {
		boolean result= false;
		if (jobTitleDao.findByTitle(jobTitle)!=null) {
			result= true;			
		}
		return result;
	}

	

}
