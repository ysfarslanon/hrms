package com.hmrs.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.hmrs.business.abstracts.JobTitleService;
import com.hmrs.core.utilities.result.*;
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
	public ResponseEntity<?> add(@Valid @RequestBody JobTitle jobTitle) {
		return ResponseEntity.ok(this.jobTitleService.add(jobTitle));
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll(){
		return this.jobTitleService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobTitle> getById(@RequestParam int id){
		return this.jobTitleService.getById(id);
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		 Map<String,String> validationErrors=new HashMap<String,String>();
		 for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
			 validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		 }
		 ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Do??rulama hatalar??.");
		 return errors;
	}
}
