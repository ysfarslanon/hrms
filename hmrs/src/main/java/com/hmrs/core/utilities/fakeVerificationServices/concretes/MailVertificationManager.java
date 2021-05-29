package com.hmrs.core.utilities.fakeVerificationServices.concretes;

import org.springframework.stereotype.Service;

import com.hmrs.core.utilities.fakeVerificationServices.abstracts.MailVertificationService;

@Service
public class MailVertificationManager implements MailVertificationService{

	@Override
	public boolean isVerifyMail(String mail) {
		return true;
	}

}
