package com.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill,Integer>{

	List<Skill> findAllByCv_Id(int cvId);
}
