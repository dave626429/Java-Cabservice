package com.thinkifylab.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Component
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;

	@OneToOne(targetEntity = Details.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id")
	private Details details;

	@OneToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id")
	private Location<Long, Long> location;
}
