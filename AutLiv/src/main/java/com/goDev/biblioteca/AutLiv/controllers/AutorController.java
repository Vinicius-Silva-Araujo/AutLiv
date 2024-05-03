package com.goDev.biblioteca.AutLiv.controllers;

import com.goDev.biblioteca.AutLiv.entities.Autor;
import com.goDev.biblioteca.AutLiv.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping(value = "/cadastro")
    public ResponseEntity<String> cadastrar(@RequestBody Autor autor) {
        if (repository.findByNomeautor(autor.getNomeautor()) == null){
            autor = repository.save(autor);
            return ResponseEntity.ok().body(String.valueOf(autor));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Autor já cadastrado");
    }

    @GetMapping
    public List<Autor> findAll(){
        List<Autor> result = repository.findAll();
        return  result;
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity <String> findById(@PathVariable long id){
        if (repository.existsById(id)){
            Autor result = repository.findById(id).get();
            return ResponseEntity.ok().body("Sucesso"
                    + result);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "delete")
    public ResponseEntity<String> delete ( @RequestBody Autor autor){
        if (repository.existsById(autor.getId())){
            repository.deleteById(autor.getId());
            return  ResponseEntity.ok().body("Autor excluido com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não existente");
        }

    }

    @PutMapping(value = "alterar/{id}")
    public Autor alterar(@RequestBody Autor autor){
        return  repository.save(autor);
    }

    @PatchMapping(value = "aletrarParcial/{id}")
    public ResponseEntity<String>  alteraParcial (@RequestBody Long id, @RequestBody Autor autor){
        if (repository.existsById(id)){
            repository.save(autor);
            return ResponseEntity.ok().body("sucesso em alterar");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping (value = "contador")
    public long contador(){
        return repository.count();
    }

    @GetMapping(value = "contem")
    public List<Autor> nomeContem(){
        return repository.findBynomeautorContaining("d");
    }


}
