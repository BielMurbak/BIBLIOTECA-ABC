package com.biblioteca.app.service;

import com.biblioteca.app.model.Livro;

import com.biblioteca.app.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll() {
        return livroRepository.getLivros();
    }

    public Livro findById(Integer id) {
        return livroRepository.getLivro(id);
    }

    public Livro update(Integer id, Livro livroUpdate) {
        return livroRepository.update(id, livroUpdate);
    }

    public void delete(Integer id) {
        livroRepository.delete(id);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

}
