package com.example.expenseTracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="expense")
public class Expense {
    @Id
    private Long id;

    private Instant expensedate;
    private String description;
    private String location;

    @ManyToOne
    private Category category;

    @JsonIgnore
    @ManyToOne
    private User user;
}