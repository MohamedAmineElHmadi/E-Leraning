package com.example.microservicequiz.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "level")
    private String level;
    @Column(name = "category")
    private int category;
}
