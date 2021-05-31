package com.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmrs.business.abstracts.JobPostService;
import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.entities.concretes.JobPost;

@RestController
@RequestMapping("/api/jobPost")
public class JobPostsController {

	private JobPostService jobPostService;

	@Autowired
	public JobPostsController(JobPostService jobPostService) {
		super();
		this.jobPostService = jobPostService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPost jobPost) {
		return this.jobPostService.add(jobPost);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPost>> getall(){
		return this.jobPostService.getAll();
	}
}
