package com.mazon.pokabola.resources;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.mazon.pokabola.domain.Jogador;
import com.mazon.pokabola.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jogadores")
public class JogadorResource {

    @Autowired
    private JogadorService service;

    @GetMapping
    public ResponseEntity<List<Jogador>> findAll(){
        List<Jogador> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> findById(@PathVariable(value = "id") Long id){
        Jogador jogador = service.findById(id);
        return ResponseEntity.ok().body(jogador);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Jogador jogador){
        Jogador obj = service.insert(jogador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
        // created retorna o código 201 quando um novo recurso é gerado
    }
    @PutMapping("/{id}")
    public ResponseEntity<Jogador> update(@PathVariable(value = "id") Long id, @RequestBody Jogador jogador) {
        jogador = service.update(jogador);
        return ResponseEntity.ok().body(jogador);
    }

}
