package com.authentication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

    @Id
    private String userId;
    private String userName;
    private String password;
    private String role;

}
