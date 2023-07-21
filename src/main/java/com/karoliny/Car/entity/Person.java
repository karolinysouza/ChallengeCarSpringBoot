package com.karoliny.Car.entity;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Column;

@Entity
@Table(name = "cars")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id_chassi")
    private Long idChassi;

    @Column
    private String name;
}
