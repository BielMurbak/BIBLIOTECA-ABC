package com.biblioteca.app.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;

}
