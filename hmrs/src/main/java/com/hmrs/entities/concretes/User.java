package com.hmrs.entities.concretes;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",updatable=false,nullable=false)
	private int id;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	@Column(name="password")
	private String password;

}
