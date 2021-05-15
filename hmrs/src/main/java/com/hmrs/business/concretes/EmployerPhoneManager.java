package com.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmrs.business.abstracts.EmployerPhoneService;
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
	public List<EmployerPhone> getAll() {
		
		return this.employePhoneDao.findAll();
	}

}
