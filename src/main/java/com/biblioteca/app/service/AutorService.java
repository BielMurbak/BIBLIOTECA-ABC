package com.biblioteca.app.service;


import com.biblioteca.app.model.Autor;
import com.biblioteca.app.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public String save(Autor autor) {
        autorRepository.save(autor);
        return "autor salvo com sucesso";
    }
}

 //(listAll, findById, delete, save e update