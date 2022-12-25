package edu.miu.springdata1Assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reviewComment;

    @ManyToOne
    @JsonBackReference(value="product-reviews")
    private Product product;

    @ManyToOne
    @JsonBackReference(value="user-reviews")
    private User user;
}
