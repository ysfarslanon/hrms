package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.EmployerPhone;

public interface EmployerPhoneService {

	Result add(EmployerPhone employerPhone);
	DataResult<List<EmployerPhone>> getAll();
}
