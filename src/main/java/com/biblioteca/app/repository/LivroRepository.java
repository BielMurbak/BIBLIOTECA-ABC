package com.biblioteca.app.repository;

import com.biblioteca.app.model.Livro;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LivroRepository {

    // Estrutura que serve como um banco de dados em memória
    private final List<Livro> livros = new ArrayList<>();

    // Estrutura para gerar id's
    private final AtomicInteger atomicInteger = new AtomicInteger(2);

    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros);
    }

    @PostConstruct
    public void init() {
        Livro livro = new Livro();
        livro.setId(1);
        livro.setIssn("1234-5678");
        livro.setTitulo("O Senhor dos Anéis");
        livro.setSinopse("Uma aventura épica pela Terra Média.");
        livro.setAno(1954);
        livro.setNumeroDePaginas(1216);

        livros.add(livro);
    }

    public Livro save(Livro livro) {
        // incrementa +1 no id e obtem o valor
        atomicInteger.incrementAndGet();
        livro.setId(atomicInteger.get());
        livros.add(livro);
        return livro;
    }

    public Livro getLivro(Integer id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    public void delete(Integer id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                livros.remove(livro);
                return; // sair do loop após remover
            }
        }
    }

    public Livro update(Integer id, Livro livroUpdate) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                if (livroUpdate.getIssn() != null) livro.setIssn(livroUpdate.getIssn());
                if (livroUpdate.getTitulo() != null) livro.setTitulo(livroUpdate.getTitulo());
                if (livroUpdate.getSinopse() != null) livro.setSinopse(livroUpdate.getSinopse());
                if (livroUpdate.getAno() != null) livro.setAno(livroUpdate.getAno());
                if (livroUpdate.getNumeroDePaginas() != null) livro.setNumeroDePaginas(livroUpdate.getNumeroDePaginas());
                return livro;
            }
        }
        return null;
    }


}
