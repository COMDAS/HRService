package com.das.hr.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;
}
