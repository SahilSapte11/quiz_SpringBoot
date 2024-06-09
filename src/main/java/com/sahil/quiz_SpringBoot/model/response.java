package com.sahil.quiz_SpringBoot.model;

import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

@Data
public class response {

    private Integer id;
    private String response;

}
