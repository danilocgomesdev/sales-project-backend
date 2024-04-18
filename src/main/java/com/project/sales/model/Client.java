package com.project.sales.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String adressEmail;
    private LocalDate dateOfBirth;

}
