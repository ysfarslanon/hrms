package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.entities.concretes.JobTitle;

public interface JobTitleService {
	void add(JobTitle jobTitle);
	List<JobTitle> getAll();

}
