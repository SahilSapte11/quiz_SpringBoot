package com.sahil.quiz_SpringBoot.controler;

import com.sahil.quiz_SpringBoot.model.question;
import com.sahil.quiz_SpringBoot.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class questionControler {
    @Autowired
    questionService questionservice;


    @GetMapping("allQue")
    public ResponseEntity<List<question>> giveAllQuestions(){
    return questionservice.giveAllQuestions();
}

@GetMapping("category/{str}")
public ResponseEntity<List<question>> giveQueByCategory(@PathVariable String str){
        return questionservice.giveQueByCategory(str);
}

@PostMapping("add_Questions")
    public ResponseEntity<String> addQuestion(@RequestBody question question){


        return questionservice.addQuestion(question);
}

}
