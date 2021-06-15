package com.hmrs.core.utilities.imageUpload.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hmrs.core.utilities.imageUpload.ImageUploadService;
import com.hmrs.core.utilities.result.*;

@Service
public class CloudinaryImageManager implements ImageUploadService{

	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryImageManager() {		
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","arslan10",
				"api_key","865159852315521",
				"api_secret","n0ghXLXlhxdQKh00riVhT1hES88"
				));					
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile file){
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}	

}
