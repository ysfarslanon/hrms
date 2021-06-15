package com.hmrs.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hmrs.business.abstracts.ImageService;
import com.hmrs.core.utilities.imageUpload.ImageUploadService;
import com.hmrs.core.utilities.result.*;
import com.hmrs.dataAccess.abstracts.ImageDao;
import com.hmrs.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{
	
	private ImageDao imageDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
		super();
		this.imageDao = imageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public Result add(Image image,MultipartFile multipartFile) {
		Map<String, String> uploadImage=this.imageUploadService.uploadImageFile(multipartFile).getData();
		image.setUrl(uploadImage.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Resim eklendi.");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), "Bütün resimler getirildi.");
	}

	@Override
	public DataResult<List<Image>> getAllByCvId(int cvId) {		
		return new SuccessDataResult<List<Image>>(this.imageDao.findByCv_Id(cvId), "Cv resimleri getirildi.");
	}

}
