package com.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hmrs.business.abstracts.CvService;
import com.hmrs.business.abstracts.ImageService;
import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.entities.concretes.Cv;
import com.hmrs.entities.concretes.Image;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private ImageService imageService;
	private CvService cvService;
	
	@Autowired
	public ImagesController(ImageService imageService, CvService cvService) {
		super();
		this.imageService = imageService;
		this.cvService = cvService;
	}

	@PostMapping("/add")
	public Result add(@RequestParam(value = "id") int cvId, @RequestParam(value = "imageFile") MultipartFile imageFile){
		Cv cv=this.cvService.getById(cvId).getData();
		Image image=new Image();
		image.setCv(cv);
		return this.imageService.add(image, imageFile);
	}
	
	/*
	 * @GetMapping("/getbyid") public DataResult<Image> getById(@RequestParam("id")
	 * int id){ return this.imageService.get(id); }
	 */
	
	@GetMapping("/getall")
	public DataResult<List<Image>> getAll(){
		return this.imageService.getAll();
	}
	
	
	@GetMapping("/getbycvıd")
	public DataResult<List<Image>> getAllByCvId(@RequestParam int cvId){
		return this.imageService.getAllByCvId(cvId);
	}

}
