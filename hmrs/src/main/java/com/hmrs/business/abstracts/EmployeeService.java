package com.hmrs.business.abstracts;

import java.util.List;

import com.hmrs.core.utilities.result.*;
import com.hmrs.entities.concretes.Employee;

public interface EmployeeService {
	
	Result add(Employee employee);
	DataResult<List<Employee>> getAll();
	DataResult<Employee> getById(int id);

}
