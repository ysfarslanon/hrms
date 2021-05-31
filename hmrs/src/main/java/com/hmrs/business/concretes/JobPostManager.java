package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.JobPostService;
import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.core.utilities.result.SuccessDataResult;
import com.hmrs.core.utilities.result.SuccessResult;
import com.hmrs.dataAccess.abstracts.JobPostDao;
import com.hmrs.entities.concretes.JobPost;

@Service
public class JobPostManager implements JobPostService{
	
	private JobPostDao jobPostDao;

	@Autowired
	public JobPostManager(JobPostDao jobPostDao) {
		super();
		this.jobPostDao = jobPostDao;
	}

	@Override
	public Result add(JobPost jobPost) {
		this.jobPostDao.save(jobPost);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobPost>> getAll() {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAll(), "Bütün iş ilanları getirldi.");
	}

	

}
