package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.entities.concretes.Language;

public interface LanguageService {

	public Result add(Language language);
	public DataResult<List<Language>> getAll();
	public DataResult<List<Language>> getAllByCvId(int cvId);
}
