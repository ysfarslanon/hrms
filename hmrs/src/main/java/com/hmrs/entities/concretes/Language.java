package com.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	@Column(name="name")
	@NotBlank
	@NotNull
	@Length(min=1,max=50)
	private String name;
	
	@Column(name="level")
	@NotNull
	@Max(value=5)
	@Min(value=1)
	private	int level;
	
}
