package edu.miu.springdata1Assignment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value="user-reviews")
    private List<Review> reviews;

    @OneToOne(mappedBy ="user" )
    @JsonManagedReference(value="user-address")
    private Address address;
}
