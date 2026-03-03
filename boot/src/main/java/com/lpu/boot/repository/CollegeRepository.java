package com.lpu.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.boot.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>{

}
