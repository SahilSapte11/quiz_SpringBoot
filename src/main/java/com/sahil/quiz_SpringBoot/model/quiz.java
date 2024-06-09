package com.sahil.quiz_SpringBoot.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Entity
@Data
public class quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<question> questions;



}
