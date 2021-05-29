package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.EmployerPhoneService;
import com.hmrs.core.utilities.result.DataResult;
import com.hmrs.core.utilities.result.Result;
import com.hmrs.core.utilities.result.SuccessDataResult;
import com.hmrs.core.utilities.result.SuccessResult;
import com.hmrs.dataAccess.abstracts.EmployerPhoneDao;
import com.hmrs.entities.concretes.EmployerPhone;

@Service
public class EmployerPhoneManager implements EmployerPhoneService{

	private EmployerPhoneDao employePhoneDao;
	
	@Autowired
	public EmployerPhoneManager(EmployerPhoneDao employePhoneDao) {
		super();
		this.employePhoneDao = employePhoneDao;
	}

	@Override
	public DataResult<List<EmployerPhone>> getAll() {
		
		return new SuccessDataResult<List<EmployerPhone>>(this.employePhoneDao.findAll());
	}

	@Override
	public Result add(EmployerPhone employerPhone) {
		this.employePhoneDao.save(employerPhone);
		return new SuccessResult("İş veren telefonu eklendi");
	}

}
