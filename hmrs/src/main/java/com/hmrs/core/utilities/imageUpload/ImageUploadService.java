package com.hmrs.core.utilities.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.hmrs.core.utilities.result.DataResult;

public interface ImageUploadService {

	DataResult<Map> uploadImageFile(MultipartFile file);
}
