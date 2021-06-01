package com.hmrs.dataAccess.abstracts;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmrs.entities.concretes.JobPost;

public interface JobPostDao extends JpaRepository<JobPost,Integer>{

	List<JobPost> findByIsStatusTrue();
	List<JobPost> findByIsStatusTrueAndDeadlineDateBefore(Date date);
	List<JobPost> findAllByIsStatusTrueOrderByPublishDateAsc();
	List<JobPost> findAllByIsStatusTrueOrderByPublishDateDesc();
	List<JobPost> findAllByIsStatusTrueOrderByDeadlineDateAsc();
	List<JobPost> findAllByIsStatusTrueOrderByDeadlineDateDesc();
	List<JobPost> findByIsStatusTrueAndEmployer_Id(int companyId);
}
