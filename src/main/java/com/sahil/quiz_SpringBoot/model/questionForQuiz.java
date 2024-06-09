package com.sahil.quiz_SpringBoot.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

public class questionForQuiz {

    private Integer id;
    private String que_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public questionForQuiz(Integer id, String que_title,String option1,String option2, String option3, String option4) {
        this.id = id;
        this.option1 = option1;
        this.que_title = que_title;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
