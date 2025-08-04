package com.biblioteca.app.repository;

import com.biblioteca.app.model.Biblioteca;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BibliotecaRepository {

    private final List<Biblioteca> bibliotecas = new ArrayList<>();

    private final AtomicInteger atomicInteger = new AtomicInteger(2);

    public List<Biblioteca> getBibliotecas(){return Collections.unmodifiableList(bibliotecas);}

    @PostConstruct
    public void init(){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(1);
        biblioteca.setNome("Alexandria");
        biblioteca.setTelefone("(45) 9999-9999");

        bibliotecas.add(biblioteca);
    }

    public Biblioteca save(Biblioteca biblioteca){
        atomicInteger.incrementAndGet();
        biblioteca.setId(atomicInteger.get());
        bibliotecas.add(biblioteca);
        return biblioteca;
    }

    public Biblioteca getBiblioteca(Integer id){
        for(Biblioteca biblioteca : bibliotecas){
            if(biblioteca.getId().equals(id)){
                return biblioteca;
            }
        }
        return null;
    }

    public void delete(Integer id){
        for(Biblioteca biblioteca : bibliotecas){
            if(biblioteca.getId().equals(id)){
                bibliotecas.remove(biblioteca);
                return;
            }
        }
    }

    public Biblioteca update(Integer id, Biblioteca bibliotecaUpgrade){
        for(Biblioteca biblioteca : bibliotecas){
            if(biblioteca.getId().equals(id)){
                if(bibliotecaUpgrade.getNome() != null) biblioteca.setNome(bibliotecaUpgrade.getNome());
                if(bibliotecaUpgrade.getTelefone() != null) biblioteca.setTelefone(bibliotecaUpgrade.getTelefone());
                return biblioteca;
            }
        }
        return null;
    }
}
