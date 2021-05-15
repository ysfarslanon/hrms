package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.entities.concretes.Employer;

public interface EmployerService {
	void add(Employer employer);
	List<Employer> getAll();
}
