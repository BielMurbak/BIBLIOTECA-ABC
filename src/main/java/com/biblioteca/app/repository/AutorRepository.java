package com.biblioteca.app.repository;


import com.biblioteca.app.model.Autor;
import com.biblioteca.app.service.AutorService;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AutorRepository {
    private final List<Autor> autores = new ArrayList<>();

    public void save(Autor autor) {
        autores.add(autor);
    }


}