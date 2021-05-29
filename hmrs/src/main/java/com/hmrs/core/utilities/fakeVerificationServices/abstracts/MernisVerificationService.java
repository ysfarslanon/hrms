package com.hmrs.core.utilities.fakeVerificationServices.abstracts;

import com.hmrs.entities.concretes.Candidate;

public interface MernisVerificationService {

	//Fake mernis ile Candidate(İş arayanlar) kontrol edilmektedir.
		public boolean isRealPerson(Candidate candidate);
	

}