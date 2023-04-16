package com.springboot.dullah.repository;

import com.springboot.dullah.entity.Football;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Football, Long> {
}
