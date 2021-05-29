package com.hmrs.core.utilities.fakeVerificationServices.concretes;

import com.hmrs.core.utilities.fakeVerificationServices.abstracts.MailVertificationService;

public class MailVertificationManager implements MailVertificationService{

	@Override
	public boolean isVerifyMail(String mail) {
		return true;
	}

}
