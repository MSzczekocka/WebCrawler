package com.example.webcrawler.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "visitedurl")
public class VisitedUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

//    @Column(unique=true)
    private String visitedUrl;

    public VisitedUrl() {
    }
}
