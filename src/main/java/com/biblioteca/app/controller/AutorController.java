package com.biblioteca.app.controller;


import com.biblioteca.app.model.Autor;


import com.biblioteca.app.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;


    @PostMapping
    @RequestMapping("/save")//
    private ResponseEntity<String> save(@RequestBody Autor autor) {
        try {
            String texto = autorService.save(autor);
            return new ResponseEntity<>(texto, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @RequestMapping("/findAll")//
    private ResponseEntity<?> listar() {
        try {

            List<Autor> autores = autorService.listarTodos();

            if(autores.isEmpty()){
                return new ResponseEntity<>("Erro nao tem autores", HttpStatus.CONFLICT);
            }

            autorService.listarTodos();
            return new ResponseEntity<>(autores, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")//
    public ResponseEntity<?> listar(@PathVariable Integer id) {
        try {
            Autor autor = autorService.findById(id);
            if (autor != null) {
                return new ResponseEntity<>(autor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Autor não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")//
    private ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            autorService.delete(id);
            return new ResponseEntity<>("Autor removido", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Erro", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> update(@PathVariable Integer id, @RequestBody Autor autor) {
        try {
            Autor atualizado = autorService.update(id, autor );
            if (atualizado == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
