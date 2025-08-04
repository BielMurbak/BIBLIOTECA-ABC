package com.biblioteca.app.service;

import com.biblioteca.app.model.Editora;
import com.biblioteca.app.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Serviço que contém a lógica de negócio para editoras
@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    // Salvar editora
    public Editora save(Editora editora) {
        return editoraRepository.save(editora);
    }

    // Listar todas as editoras
    public List<Editora> listAll() {
        return editoraRepository.findAll();
    }

    // Buscar editora por ID
    public Optional<Editora> findById(Integer id) {
        return editoraRepository.findById(id);
    }

    // Deletar editora por ID
    public boolean delete(Integer id) {
        return editoraRepository.deleteById(id);
    }

    // Atualizar editora
    public Editora update(Editora editora) {
        return editoraRepository.save(editora);
    }
}