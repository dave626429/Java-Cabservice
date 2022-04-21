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
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
	private String registrationNumber;
	private Integer income = 0;
	private Boolean status = true;
	private String carModel;

	@OneToOne(targetEntity = Details.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "driver_details_fk", referencedColumnName = "id")
	private Details details;

	@OneToOne(targetEntity = Location.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "driver_location_fk", referencedColumnName = "id")
	private Location<Long, Long> location;

}
