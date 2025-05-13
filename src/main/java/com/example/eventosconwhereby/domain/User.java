package com.example.eventosconwhereby.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Meeting meeting;
}
