package com.vizavi.application.repositories;


import com.vizavi.application.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}


