package com.example.dtopattern.repository;

import com.example.dtopattern.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}


