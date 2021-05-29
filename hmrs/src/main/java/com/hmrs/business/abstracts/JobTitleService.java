package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.entities.concretes.JobTitle;

public interface JobTitleService {
	Result add(JobTitle jobTitle);
	DataResult<List<JobTitle>>  getAll();

}
