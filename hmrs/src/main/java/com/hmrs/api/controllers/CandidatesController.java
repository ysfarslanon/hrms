package com.hmrs.api.controllers;

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

import com.hmrs.business.abstracts.CandidateService;
import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.Candidate;



@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate) {
		return ResponseEntity.ok(this.candidateService.add(candidate));
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<Candidate> getById(@RequestParam int id){
		return this.candidateService.getById(id);
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
