package com.example.library.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Getter @Setter
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String membership;
}
