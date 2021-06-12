package com.hmrs.api.controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hmrs.business.abstracts.JobPostService;
import com.hmrs.core.utilities.result.*;
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
	public ResponseEntity<?> add(@Valid @RequestBody JobPost jobPost) {
		return ResponseEntity.ok(this.jobPostService.add(jobPost));
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
	
	@GetMapping("/getByStatusActiveAndCompanyId")
	public DataResult<List<JobPost>> getByStatusActiveAndEmployerId(int employerId){
		return this.jobPostService.getByStatusActiveAndEmployerId(employerId);
	}
	
	@GetMapping("/getById")
	public DataResult<JobPost> getById(@RequestParam int jobPostId){
		return this.jobPostService.getById(jobPostId);
	}
	
	@GetMapping("/setStatus")
	public DataResult<JobPost> setStatus(@RequestParam  int jobPostId,@RequestParam int employerId,@RequestParam boolean isStatus){
		return this.jobPostService.setStatus(jobPostId, employerId, isStatus);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		 Map<String,String> validationErrors=new HashMap<String,String>();
		 for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
			 validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		 }
		 ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları.");
		 return errors;
	}
	
}
