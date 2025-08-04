package com.biblioteca.app.controller;
import com.biblioteca.app.model.Biblioteca;
import com.biblioteca.app.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Biblioteca>> findAll(){
        try{
            var result = bibliotecaService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable Integer id){
        try{
            Biblioteca biblioteca = bibliotecaService.findById(id);
            if(biblioteca == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(biblioteca,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Biblioteca> save(@RequestBody Biblioteca biblioteca){
        try {
            Biblioteca salvo = bibliotecaService.save(biblioteca);
            return new ResponseEntity<>(salvo, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Biblioteca> update(@PathVariable Integer id, @RequestBody Biblioteca biblioteca){
        try {
            Biblioteca atualizado = bibliotecaService.update(id, biblioteca);
            if(atualizado == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(atualizado,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        try{
            bibliotecaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
