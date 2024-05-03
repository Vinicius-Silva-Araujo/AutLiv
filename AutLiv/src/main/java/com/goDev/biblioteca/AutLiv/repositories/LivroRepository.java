package com.goDev.biblioteca.AutLiv.repositories;

import com.goDev.biblioteca.AutLiv.entities.Autor;
import com.goDev.biblioteca.AutLiv.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
//    List<Livro> findBynomeautorContaining(String termo);
}
