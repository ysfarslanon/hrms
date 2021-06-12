package com.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_posts"})
public class JobTitle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	@NotNull
	@NotBlank
	private String title;
	
	@OneToMany(mappedBy="jobTitle")
	@JsonIgnore
	private List<JobPost> jobPost;
}
