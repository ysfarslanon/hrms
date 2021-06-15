package com.hmrs.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.entities.concretes.Image;

public interface ImageService {

	Result add(Image image,MultipartFile multipartFile);
	DataResult<List<Image>> getAll();
	DataResult<List<Image>> getAllByCvId(int cvId);
}
