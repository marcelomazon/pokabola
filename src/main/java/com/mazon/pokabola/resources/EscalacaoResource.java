package com.mazon.pokabola.resources;

import com.mazon.pokabola.domain.Escalacao;
import com.mazon.pokabola.services.EscalacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/escalacao")
public class EscalacaoResource {

    @Autowired
    private EscalacaoService service;

    @GetMapping
    public ResponseEntity<List<Escalacao>> findAll(){
        List<Escalacao> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escalacao> findById(@PathVariable(value = "id") Long id){
        Escalacao escalacao = service.findById(id);
        return ResponseEntity.ok().body(escalacao);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Escalacao escalacao){
        Escalacao obj = service.insert(escalacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escalacao> update(@PathVariable(value = "id") Long id, @RequestBody Escalacao escalacao) {
        escalacao = service.update(escalacao);
        return ResponseEntity.ok().body(escalacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Escalacao> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
