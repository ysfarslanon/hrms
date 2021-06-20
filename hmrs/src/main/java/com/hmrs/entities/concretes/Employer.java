package com.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_posts"})
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {
	

	@Column(name="company_name")
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name="web_address")
	@NotNull
	@NotBlank
	private String webAddress;
	
	@Column(name="phone")
	@NotNull
	@NotBlank
	private String phone;
	
	@JsonIgnore
	@OneToMany(mappedBy="employer")
	private List<JobPost> jobPosts;
	
}
