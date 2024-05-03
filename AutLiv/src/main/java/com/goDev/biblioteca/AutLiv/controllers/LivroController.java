package com.goDev.biblioteca.AutLiv.controllers;

import com.goDev.biblioteca.AutLiv.entities.Livro;
import com.goDev.biblioteca.AutLiv.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PostMapping(value = "/cadastrar")
    public Livro cadastrar (@RequestBody Livro livro){
        return repository.save(livro);
    }
    @GetMapping(value = "/buscarTodosLivros")
    public List<Livro> findAll(){
        List<Livro> result = repository.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public Livro findById(@PathVariable long id){
        Livro result = repository.findById(id).get();
        return  result;
    }
    @DeleteMapping(value = "delete")
    public ResponseEntity<String> delete ( @RequestBody Livro livro){
        if(repository.existsById(livro.getId())){
            repository.deleteById(livro.getId());
            return ResponseEntity.ok().body("Livro deletado com sucesso." + livro);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não existe");
        }
    }
    @PutMapping(value = "alterar/{id}")
    public ResponseEntity<String> aletar(@PathVariable long id, @RequestBody Livro livro){
        if(repository.existsById(id)){
            repository.save(livro);
            return  ResponseEntity.ok().body("sucesso");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/contatodor")
    public long contator(){
        return repository.count();
    }
}
