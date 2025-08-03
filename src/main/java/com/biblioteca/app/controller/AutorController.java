package com.biblioteca.app.controller;


import com.biblioteca.app.model.Autor;
import com.biblioteca.app.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;


    @PostMapping
    @RequestMapping("/save")
    private ResponseEntity<String> save(@RequestBody Autor autor) {
        try {
            String texto = autorService.save(autor);
            return new ResponseEntity<>(texto, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Erro", HttpStatus.BAD_REQUEST);
        }
    }

}
