package com.biblioteca.app.model;


import lombok.*;

@Data
//@Entity
//@Table(name = "Biblioteca")
public class Biblioteca {

   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String telefone;

}
