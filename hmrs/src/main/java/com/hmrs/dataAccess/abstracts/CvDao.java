package com.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv,Integer>{

	List<Cv> findAllByCandidate_Id(int candidateId);
}
