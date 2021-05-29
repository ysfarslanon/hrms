package com.hmrs.business.concretes;

import java.util.List;

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
		if (isFieldNull(candidate)) {
			return new ErrorResult("Boş alan bırakmayınız.");
		}
		else if (!mernisVerification.isRealPerson(candidate)) {
			return new ErrorResult("Gerçek kişi hatası");
		}
		else if (this.candidateDao.findByIdentificationNumber(candidate.getIdentificationNumber())!=null) {
			return new ErrorResult("Girmiş olduğunuz kimlik numarası sistemde zaten mevcuttur.");
		}
		else if (this.candidateDao.findByEmailAddress(candidate.getEmailAddress())!=null) {
			return new ErrorResult("Girmiş olduğunuz E-Posta adresi sistemde mevuttur.");
		}
		this.mailVerification.isVerifyMail(candidate.getEmailAddress());
		this.candidateDao.save(candidate);
		return new SuccessResult("Ekleme başarılı.");
	
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"İş arayanlar getirildi");
		
	}
	
	private boolean isFieldNull(Candidate candidate) {
		boolean result=false;
		if (candidate.getBirthDate()==null||candidate.getEmailAddress().isEmpty()||candidate.getFirstName().isEmpty()
				||candidate.getIdentificationNumber().isEmpty()||candidate.getLastName().isEmpty()||candidate.getPassword().isEmpty()) {
			result=true;				
		}					
		System.out.println("--"+result);
		return result;		
	}
	

}
