package com.hmrs.business.abstracts;

import java.sql.Date;
import java.util.List;


import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.JobPost;

public interface JobPostService {

	Result add(JobPost jobPost);
	DataResult<List<JobPost>> getAll();
	DataResult<List<JobPost>> getByStatusActive();
	DataResult<List<JobPost>> getByStatusActiveAndDeadlineBefore(Date date);
	DataResult<List<JobPost>> getByStatusActivePublishDateAsc();
	DataResult<List<JobPost>> getByStatusActivePublishDateDesc();
	DataResult<List<JobPost>> getByStatusActiveDeadlineDateAsc();
	DataResult<List<JobPost>> getByStatusActiveDeadlineDateDesc();
}
