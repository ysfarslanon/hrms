package com.hmrs.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.EmployerService;
import com.hmrs.core.utilities.fakeVerificationServices.abstracts.MailVertificationService;
import com.hmrs.core.utilities.result.*;
import com.hmrs.dataAccess.abstracts.EmployerDao;
import com.hmrs.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private MailVertificationService mailVerification;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,MailVertificationService mailVerification) {
		super();
		this.employerDao = employerDao;
		this.mailVerification=mailVerification;
	}

	@Override
	public Result add(Employer employer) {
		
		if (!isSameDomain(employer)) {
			return new ErrorResult("Mail adresi web sitesine uygun değildir.");
		}
		else if(isFieldNull(employer)) {
			return new ErrorResult("Boş alan bırakmayınız.");
		}
		else if(isMailExist(employer)) {
			return new ErrorResult("Girmiş olduğunuz mail sistemde muvcuttur.");
		}
		this.mailVerification.isVerifyMail(employer.getEmailAddress());
		this.employerDao.save(employer);
		return new SuccessResult("Şirket eklendi");
		
	}
//Todo: hrms onayı
	@Override
	public DataResult<List<Employer>> getAll() {		
		return new SuccessDataResult(this.employerDao.findAll(), "Şirketler Listelendi");
	}
	
	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id),"Şerket getirildi");
	}
	
//-------------------------BUSİNESS RULES-------------
	private boolean isFieldNull(Employer employer) {
		boolean result=false;
		if (employer.getCompanyName().isEmpty()||employer.getWebAddress().isEmpty()||employer.getPassword().isEmpty()
				||employer.getPhone().isEmpty()){
			result=true;				
		}						
		return result;		
	}
	
	private boolean isEmail(String mail) {
		String emailPattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern =Pattern.compile(emailPattern,Pattern.CASE_INSENSITIVE);
		boolean result= pattern.matcher(mail).find();
		if (result) {
			return true;
			}		
		return false;
	}
	
	private boolean isMailExist(Employer employer) {
		boolean result=false;
		if (employerDao.findByEmailAddress(employer.getEmailAddress())!=null) {
			result= true;
		}		
		return result;
	}
	
	private boolean isSameDomain(Employer employer) {
		String mail=employer.getEmailAddress();
		String[] mailSplit=mail.split("@");
		if (mailSplit[1].equals(employer.getWebAddress())) {
			return true;
		}		
		return false;
	}

	
}
