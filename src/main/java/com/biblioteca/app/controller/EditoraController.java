package com.biblioteca.app.controller;

import com.biblioteca.app.model.Editora;
import com.biblioteca.app.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controlador REST para gerenciar editoras
@RestController
@RequestMapping("/api/editoras")
public class EditoraController {

    @Autowired
    private EditoraService editoraService;

    // POST - Salvar nova editora
    @PostMapping
    public ResponseEntity<Editora> save(@RequestBody Editora editora) {
        try {
            Editora savedEditora = editoraService.save(editora);
            return new ResponseEntity<>(savedEditora, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // GET - Listar todas as editoras
    @GetMapping
    public ResponseEntity<List<Editora>> listAll() {
        try {
            List<Editora> editoras = editoraService.listAll();
            return new ResponseEntity<>(editoras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET - Buscar editora por ID
    @GetMapping("/{id}")
    public ResponseEntity<Editora> findById(@PathVariable Integer id) {
        try {
            Optional<Editora> editora = editoraService.findById(id);
            return editora.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // PUT - Atualizar editora
    @PutMapping("/{id}")
    public ResponseEntity<Editora> update(@PathVariable Integer id, @RequestBody Editora editora) {
        try {
            editora.setId(id);
            Editora updatedEditora = editoraService.update(editora);
            return new ResponseEntity<>(updatedEditora, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // DELETE - Deletar editora por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            boolean deleted = editoraService.delete(id);
            if (deleted) {
                return new ResponseEntity<>("Editora deletada com sucesso", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Editora não encontrada", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar editora", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}