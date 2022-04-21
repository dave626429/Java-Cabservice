package com.thinkifylab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thinkifylab.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
