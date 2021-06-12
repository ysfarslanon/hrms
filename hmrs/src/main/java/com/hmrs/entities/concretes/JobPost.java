package com.hmrs.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="job_postings")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPost {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	
	@ManyToOne
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="definition")
	@NotNull
	@NotBlank
	private String definition;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="quantity")
	@NotNull
	private int quantity;
	
	@Column(name="deadline_date")
	private Date deadlineDate;
	
	@Column(name="publish_date")	
	private Date publishDate;
	
	@Column(name="is_status")	
	private boolean isStatus;
	
}
