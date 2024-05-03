package com.goDev.biblioteca.AutLiv.repositories;

import com.goDev.biblioteca.AutLiv.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findBynomeautorContaining(String termo);
     public Autor findByNomeautor(String nomeautor);

    /*@Query(value = "SELECT SUN(idade) FROM Autore", nativeQuery = true)
    int somaAutores();*/

}
//public record AutorRecordDto(@NotBlank String nomeautor, @NotNull nacionalidade){
//
//}
