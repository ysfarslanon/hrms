package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.JobPost;

public interface JobPostService {

	Result add(JobPost jobPost);
	DataResult<List<JobPost>> getAll();
	
}
