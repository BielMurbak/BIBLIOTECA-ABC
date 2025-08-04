package com.biblioteca.app.repository;

import com.biblioteca.app.model.Editora;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Repository para acesso aos dados de editoras
@Repository
public class EditoraRepository {
    // Lista em memória para armazenar editoras (simulação de banco de dados)
    private final List<Editora> editoras = new ArrayList<>();
    private Integer nextId = 1;

    // Salvar editora
    public Editora save(Editora editora) {
        if (editora.getId() == null) {
            editora.setId(nextId++);
            editoras.add(editora);
        } else {
            update(editora);
        }
        return editora;
    }

    // Listar todas as editoras
    public List<Editora> findAll() {
        return new ArrayList<>(editoras);
    }

    // Buscar editora por ID
    public Optional<Editora> findById(Integer id) {
        return editoras.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    // Deletar editora por ID
    public boolean deleteById(Integer id) {
        return editoras.removeIf(e -> e.getId().equals(id));
    }

    // Atualizar editora
    private void update(Editora editora) {
        for (int i = 0; i < editoras.size(); i++) {
            if (editoras.get(i).getId().equals(editora.getId())) {
                editoras.set(i, editora);
                break;
            }
        }
    }
}