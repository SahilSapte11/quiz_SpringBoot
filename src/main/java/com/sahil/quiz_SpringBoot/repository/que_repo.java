package com.sahil.quiz_SpringBoot.repository;

import com.sahil.quiz_SpringBoot.model.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface que_repo extends JpaRepository<question,Integer> {

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT:numQue", nativeQuery = true)
    List<question> findRandomQuestionByCategory(String category, int numQue);

    List<question> findByCategory(String str);
}
