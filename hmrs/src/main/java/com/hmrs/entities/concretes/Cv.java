package com.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cvs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cv {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")		
	private Candidate candidate;
	
	@Column(name="github")
	@NotNull
	@NotBlank
	@Size(min=1,max=100)
	private String github;
	
	@Column(name="linkedin")
	@NotNull
	@NotBlank
	@Size(min=1,max=200)
	private String linkedin;
	
	@Column(name="cover_letter")
	@NotNull
	@NotBlank
	@Size(min=1,max=500)
	private String coverLetter;
	
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Language> languages;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Skill> skills;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<School> schools;
}
