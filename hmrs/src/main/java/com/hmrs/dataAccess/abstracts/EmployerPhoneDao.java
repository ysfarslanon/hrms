package com.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.EmployerPhone;

public interface EmployerPhoneDao extends JpaRepository<EmployerPhone,Integer>{

}
