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

    public List<Autor> listAll() {
        return autores;
    }

    public Autor findById(Integer id) {
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                return autor;
            }
        }
        return null;
    }

    public void deleteById(Integer id) {
        Autor autor = findById(id);
        if (autor != null) {
            autores.remove(autor);
        }
    }
    public Autor update(Integer id, Autor autorUpdate) {
        for (Autor autor : autores) {
            if (autor.getId()==id) {
                if (autorUpdate.getNome() != null) autor.setNome(autorUpdate.getNome());
                if (autorUpdate.getCpf() != null) autor.setCpf(autorUpdate.getCpf());
                if (autorUpdate.getIdade() != null) autor.setIdade(autorUpdate.getIdade());
                return autor;
            }
        }
        return null;
    }

}

