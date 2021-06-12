package com.hmrs.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.CandidateService;
import com.hmrs.core.utilities.fakeVerificationServices.abstracts.MailVertificationService;
import com.hmrs.core.utilities.fakeVerificationServices.abstracts.MernisVerificationService;
import com.hmrs.core.utilities.result.*;
import com.hmrs.dataAccess.abstracts.CandidateDao;
import com.hmrs.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private MernisVerificationService mernisVerification;
	private MailVertificationService mailVerification;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisVerificationService mernisVerification,MailVertificationService mailVerification) {
		super();
		this.candidateDao = candidateDao;
		this.mernisVerification=mernisVerification;
		this.mailVerification=mailVerification;
	}

	@Override
	public Result add(Candidate candidate) {
		
		if (!mernisVerification.isRealPerson(candidate)) {
			return new ErrorResult("Gerçek kişi hatası");
		}
		else if (isIdentificationNumber(candidate)) {
			return new ErrorResult("Girmiş olduğunuz kimlik numarası sistemde zaten mevcuttur.");
		}
		else if(isMailExist(candidate)) {
			return new ErrorResult("Girmiş olduğunuz mail sistemde muvcuttur.");
		}
		this.mailVerification.isVerifyMail(candidate.getEmailAddress());
		this.candidateDao.save(candidate);
		return new SuccessResult("Ekleme başarılı.");
	
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar getirildi");
		
	}
	
	//------------BUSİNESS RULES--------------

	private boolean isMailExist(Candidate candidate) {
		boolean result=false;
		if (candidateDao.findByEmailAddress(candidate.getEmailAddress())!=null) {
			result= true;
		}		
		return result;
	}
	private boolean isIdentificationNumber(Candidate candidate) {
		boolean result=false;
		if (candidateDao.findByIdentificationNumber(candidate.getIdentificationNumber())!=null) {
			result= true;
		}		
		return result;
	}
	
	
	

}
