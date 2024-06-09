package com.sahil.quiz_SpringBoot.service;

import com.sahil.quiz_SpringBoot.model.question;
import com.sahil.quiz_SpringBoot.repository.que_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionService {
    @Autowired
    que_repo queRepo;

    public ResponseEntity<List<question>> giveAllQuestions() {

        return new ResponseEntity<>(queRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<question>> giveQueByCategory(String str) {
        return new ResponseEntity<>(queRepo.findByCategory(str),HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(question question) {
        queRepo.save(question);

        return new ResponseEntity<>("added",HttpStatus.CREATED);
    }
}
