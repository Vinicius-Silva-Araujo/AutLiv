package com.goDev.biblioteca.AutLiv.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private int anopublicacao;

    @ManyToOne(targetEntity = Autor.class)
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

}
