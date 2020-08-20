package com.fa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name = "clazz_id")
	private Clazz clazz;

}
