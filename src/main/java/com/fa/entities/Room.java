package com.fa.entities;

import javax.persistence.*;

@Table
@Entity
public class Room {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private String hotel;

	@OneToOne(mappedBy = "room")
	private Tourist tourist;

}
