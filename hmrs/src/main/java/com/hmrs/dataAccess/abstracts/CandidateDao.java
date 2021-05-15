package com.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
//optional
}
