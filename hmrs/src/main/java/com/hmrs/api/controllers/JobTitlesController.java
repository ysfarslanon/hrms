package com.hmrs.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmrs.business.abstracts.JobTitleService;
import com.hmrs.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {
	
	private JobTitleService jobTitleService;

	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody JobTitle jobTitle) {
		this.jobTitleService.add(jobTitle);
	}
	
	@GetMapping("/getall")
	public List<JobTitle> getAll(){
		return this.jobTitleService.getAll();
	}

}