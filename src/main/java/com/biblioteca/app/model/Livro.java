package com.biblioteca.app.model;

import lombok.*;

//@Entity
//@Table(name = "Livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

   // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String issn;
    private String titulo;
    private String sinopse;
    private Integer ano;
    private Integer numeroDePaginas;

}
