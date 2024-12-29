package com.example.dtopattern.repository;

import com.example.dtopattern.entity.StatusVal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusVal, Integer> {
}
