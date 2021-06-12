package com.hmrs.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="candidates")
public class Candidate extends User{

	@Column(name="first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name="identification_number")
	@NotBlank
	@NotNull
	private String identificationNumber;
	
	@Column(name="birth_date")
	@NotNull
	private Date birthDate;
	
	
}
