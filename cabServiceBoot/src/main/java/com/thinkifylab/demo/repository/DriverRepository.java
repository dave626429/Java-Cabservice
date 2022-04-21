package com.thinkifylab.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkifylab.demo.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
	
	public List<Driver> findByStatus(Boolean status);

}
