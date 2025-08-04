package com.biblioteca.app.service;


import com.biblioteca.app.model.Autor;
import com.biblioteca.app.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public List<Autor> listarTodos() {
        List<Autor> autores = autorRepository.listAll();
        return autores;
    }
    public Autor findById(Integer id) {
        List<Autor> autores = autorRepository.listAll();
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                return autor;
            }
        }
        return null;
    }

    public Autor delete(Integer id) {

        List<Autor> autores = autorRepository.listAll();

        for (int i = 0; i < autores.size(); i++) {
            Autor autor = autores.get(i);

            if (autor.getId() == id) {
                autores.remove(i);
                return autor;
            }
        }
        return null;
    }

    public Autor update(Integer id, Autor autorUpdate) {
        return autorRepository.update(id, autorUpdate);
    }
}

 //(, delete,  e update