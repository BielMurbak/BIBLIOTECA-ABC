package com.biblioteca.app.model;


import lombok.*;

// Entidade que representa uma editora no sistema
@Data
//@Entity
//@Table(name = "Editora")
public class Editora {

   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;        // Identificador único da editora
    private String nome;       // Nome da editora
    private String endereco;   // Endereço da editora
    private String telefone;   // Telefone da editora

}
