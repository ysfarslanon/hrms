package com.hmrs.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	@Override
	public DataResult<List<JobPost>> getByStatusActive() {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findByIsStatusTrue(),"Aktif ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobPost>> getByStatusActiveAndDeadlineBefore(Date date) {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findByIsStatusTrueAndDeadlineDateBefore(date),"Aktif ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobPost>> getByStatusActivePublishDateAsc() {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAllByIsStatusTrueOrderByPublishDateAsc(),"Aktif ilanlar oluşturma tarihine göre artan sıralamayla listelendi");
	}

	@Override
	public DataResult<List<JobPost>> getByStatusActivePublishDateDesc() {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAllByIsStatusTrueOrderByPublishDateDesc(),"Aktif ilanlar oluşturma tarihine göre azalan sıralamayla listelendi");
	}

	@Override
	public DataResult<List<JobPost>> getByStatusActiveDeadlineDateAsc() {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAllByIsStatusTrueOrderByDeadlineDateAsc(),"Aktif ilanlar bitiş tarihine göre artan sıralamayla listelendi");
	}

	@Override
	public DataResult<List<JobPost>> getByStatusActiveDeadlineDateDesc() {
		return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAllByIsStatusTrueOrderByDeadlineDateDesc(),"Aktif ilanlar bitiş tarihine göre azalan sıralamayla listelendi");
	}

	

}
