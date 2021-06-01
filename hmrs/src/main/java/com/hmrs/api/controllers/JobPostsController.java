package com.hmrs.api.controllers;

import java.sql.Date;
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
	
	@GetMapping("/getByStatusTrue")
	public DataResult<List<JobPost>> getByStatusActive(){
		return this.jobPostService.getByStatusActive();
	}
	
	@GetMapping("/getByStatusActiveAndDeadlineBefore")
	public DataResult<List<JobPost>> getByStatusActiveAndDeadlineBefore(Date date) {
		return this.jobPostService.getByStatusActiveAndDeadlineBefore(date);
	}
	
	@GetMapping("/getByStatusActivePublishDateAsc")
	public DataResult<List<JobPost>> getByStatusActivePublishDateAsc() {
		return this.jobPostService.getByStatusActivePublishDateAsc();
	}
	
	@GetMapping("/getByStatusActivePublishDateDesc")
	public DataResult<List<JobPost>> getByStatusActivePublishDateDesc() {
		return this.jobPostService.getByStatusActivePublishDateDesc();
	}
	@GetMapping("/getByStatusActiveDeadlineDateAsc")
	public DataResult<List<JobPost>> getByStatusActiveDeadlineDateAsc() {
		return this.jobPostService.getByStatusActiveDeadlineDateAsc();
	}
	
	@GetMapping("/getByStatusActiveDeadlineDateDesc")
	public DataResult<List<JobPost>> getByStatusActiveDeadlineDateDesc() {
		return this.jobPostService.getByStatusActiveDeadlineDateDesc();
	}
}
