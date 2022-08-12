package com.example.demo.repository;

import com.example.demo.modell.Secret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretRepository extends JpaRepository<Secret ,String> {



}
