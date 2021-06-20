package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.entities.concretes.Language;

public interface LanguageService {

	Result add(Language language);
	DataResult<List<Language>> getAll();
	DataResult<List<Language>> getAllByCvId(int cvId);
	DataResult<Language> getById(int id);
	
}
