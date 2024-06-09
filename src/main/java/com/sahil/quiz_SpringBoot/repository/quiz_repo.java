package com.sahil.quiz_SpringBoot.repository;

import com.sahil.quiz_SpringBoot.model.quiz;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quiz_repo extends JpaRepository<quiz,Integer> {
}
