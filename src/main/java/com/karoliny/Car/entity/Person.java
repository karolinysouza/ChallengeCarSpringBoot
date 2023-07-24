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

    private String name;

    private String brand;

    private String color;

    private String fabricationYear;

    public Person() {
    }

    public Person(Long idChassi, String name, String brand, String color, String fabricationYear) {
        this.idChassi = idChassi;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.fabricationYear = fabricationYear;
    }

    public Long getIdChassi() {
        return idChassi;
    }

    public void setIdChassi(Long idChassi) {
        this.idChassi = idChassi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idChassi=" + idChassi +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", fabricationYear='" + fabricationYear + '\'' +
                '}';
    }
}
