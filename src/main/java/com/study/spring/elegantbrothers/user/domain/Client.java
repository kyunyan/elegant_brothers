package com.study.spring.elegantbrothers.user.domain;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTS")
public class Client extends User {

    @Id
    @GeneratedValue
    @Column(name = "CLIENT_ID")
    private Long id;
}
