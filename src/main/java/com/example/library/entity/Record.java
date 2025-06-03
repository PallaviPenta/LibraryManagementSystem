package com.example.library.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity @Getter @Setter
public class Record {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "item_id") private Item item;
    @ManyToOne @JoinColumn(name = "person_id") private Person person;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state;
}

