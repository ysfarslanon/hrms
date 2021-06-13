package com.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language,Integer>{

	List<Language> findAllByCv_Id(int cvId);
}
