package com.hmrs.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",updatable=false,nullable=false)
	private int id;
	
	@Column(name="email_address")
	@Email
	@NotBlank
	@NotNull
	private String emailAddress;
	
	@Column(name="password")
	@NotBlank
	@NotNull
	private String password;

}
