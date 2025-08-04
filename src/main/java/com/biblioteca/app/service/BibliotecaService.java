package com.biblioteca.app.service;

import com.biblioteca.app.model.Biblioteca;

import com.biblioteca.app.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> findAll(){return bibliotecaRepository.getBibliotecas();}

    public Biblioteca findById(Integer id){return bibliotecaRepository.getBiblioteca(id);}

    public Biblioteca update(Integer id, Biblioteca bibliotecaUpdate){return bibliotecaRepository.update(id, bibliotecaUpdate);}

    public void delete(Integer id){bibliotecaRepository.delete(id);}

    public Biblioteca save(Biblioteca biblioteca){return bibliotecaRepository.save(biblioteca);}

}
