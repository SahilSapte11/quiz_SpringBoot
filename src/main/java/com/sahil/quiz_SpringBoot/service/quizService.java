package com.sahil.quiz_SpringBoot.service;

import com.sahil.quiz_SpringBoot.model.question;
import com.sahil.quiz_SpringBoot.model.questionForQuiz;
import com.sahil.quiz_SpringBoot.model.quiz;
import com.sahil.quiz_SpringBoot.model.response;
import com.sahil.quiz_SpringBoot.repository.que_repo;
import com.sahil.quiz_SpringBoot.repository.quiz_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizService {

    @Autowired
    quiz_repo quizRepo;


    @Autowired
    que_repo queRepo;

    public ResponseEntity<String> createQuiz(String category, int numQue, String title) {
        List<question> questions=queRepo.findRandomQuestionByCategory(category,numQue);

        quiz q= new quiz();
        q.setTitle(title);
        q.setQuestions(questions);
        quizRepo.save(q);

        return new ResponseEntity<>("sucess", HttpStatus.CREATED);
    }

    public ResponseEntity<List<questionForQuiz>> getQuizQuestions(Integer id) {

        Optional<quiz> quiz=quizRepo.findById(id);
        List<question> questionFromDB= quiz.get().getQuestions();
        List<questionForQuiz> questionForUser=new ArrayList<>();
        for (question q:questionFromDB){
            questionForQuiz qw=new questionForQuiz(q.getId(),q.getQue_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }


    public ResponseEntity<Integer> getTheResult(Integer id, List<response> responses) {
        quiz quiz=quizRepo.findById(id).get();
        List<question> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for (response r:responses){
            if (r.getResponse().equals(questions.get(i).getRight_answer())){
                right++;
            }
            i++;
        }
    return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
