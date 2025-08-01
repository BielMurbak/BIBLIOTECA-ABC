package com.biblioteca.app.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String inns;
    private String titulo;
    private String sinopse;
    private Integer ano;
    private Integer pagina;

}
