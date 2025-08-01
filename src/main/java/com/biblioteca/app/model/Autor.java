package com.biblioteca.app.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private Integer idade;

}
