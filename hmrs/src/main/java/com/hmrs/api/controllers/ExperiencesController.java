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

import com.hmrs.business.abstracts.ExperienceService;
import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {
	
	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Experience experience) {
		return ResponseEntity.ok(this.experienceService.add(experience));
	}
	
	@GetMapping("/getall")
	public DataResult<List<Experience>> getAll(){
		return this.experienceService.getAll();
	}
	
	@GetMapping("/getallbycvid")
	public DataResult<List<Experience>> getAllByCvId(@RequestParam int cvId){
		return this.experienceService.getAllByCvId(cvId);
	}
	
	@GetMapping("/getallbycviddesc")
	public DataResult<List<Experience>> getAllByCvIdDesc(@RequestParam int cvId){
		return this.experienceService.getAllByCvIdDesc(cvId);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Experience> getById(@RequestParam int id){
		return this.experienceService.getById(id);
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
