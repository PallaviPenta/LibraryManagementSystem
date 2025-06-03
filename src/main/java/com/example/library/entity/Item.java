package com.example.library.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity @Getter @Setter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String writer;
    private String type;
    private boolean isAvailable = true;
}
