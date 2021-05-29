package com.hmrs.core.utilities.fakeVerificationServices.concretes;

import org.springframework.stereotype.Service;

import com.hmrs.core.utilities.fakeVerificationServices.abstracts.MernisVerificationService;
import com.hmrs.entities.concretes.Candidate;

@Service
public class MernisVerificationManager implements MernisVerificationService{

	@Override
	public boolean isRealPerson(Candidate candidate) {
		boolean result=false;
		if (candidate.getIdentificationNumber().length()==11) {
			result=true;
		}
		return result;
	}

}
