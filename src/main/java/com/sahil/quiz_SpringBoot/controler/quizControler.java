package com.sahil.quiz_SpringBoot.controler;

import com.sahil.quiz_SpringBoot.model.questionForQuiz;
import com.sahil.quiz_SpringBoot.model.response;
import com.sahil.quiz_SpringBoot.service.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class quizControler {

@Autowired
    quizService quizService;

@PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int num_que,@RequestParam String title){

    return quizService.createQuiz(category,num_que,title);
}

@PostMapping("get/{id}")
public ResponseEntity<List<questionForQuiz>> getQuizQuestions(@PathVariable Integer id){

    return quizService.getQuizQuestions(id);
}

@PostMapping("submit/{id}")
public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<response> responses){

    return quizService.getTheResult(id,responses);
}

}
