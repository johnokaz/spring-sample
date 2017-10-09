package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    
    @Id
    private String username;

    @JsonIgnore
    private String encodedPassword;
    
    private String firstname;
    private String lastname;
    private String mail;
    
    private Timestamp lastLoginOn;
    private Timestamp createdOn;
    private Timestamp updatedOn;
}
