package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.LanguageService;
import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.core.utilities.result.SuccessDataResult;
import com.hmrs.core.utilities.result.SuccessResult;
import com.hmrs.dataAccess.abstracts.LanguageDao;
import com.hmrs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Dil eklendi");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Diller listelendi");
	}

	@Override
	public DataResult<List<Language>> getAllByCvId(int cvId) {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAllByCv_Id(cvId), "CV dilleri listelendi");
	}
}
