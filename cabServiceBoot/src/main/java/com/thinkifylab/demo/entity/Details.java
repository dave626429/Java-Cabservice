package com.thinkifylab.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Component
@Data
public class Details {
	
//	** only for PostgreSQL like RDMS, MySQL no support for sequence creation
//	@GeneratedValue(generator = "sequence-generator")
//	@GenericGenerator(
//		name = "sequence-generator",
//		strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
//		parameters = {
//			@Parameter(name = "details_sequence_generator", value = "details_id_sequence"),
//			@Parameter(name = "initial_value", value = "1000001"),
//			@Parameter(name = "increment_size", value = "1") 
//		}
//	)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;
	private String name;
	private Long phone;
	private String address;
	private String gender;
	private Integer age;
}
