package com.mazon.pokabola.resources;

import com.mazon.pokabola.domain.Jogador;
import com.mazon.pokabola.domain.Time;
import com.mazon.pokabola.services.JogadorService;
import com.mazon.pokabola.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeResource {

    @Autowired
    private TimeService service;

    @GetMapping
    public ResponseEntity<List<Time>> findAll(){
        List<Time> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> findById(@PathVariable(value = "id") Long id){
        Time time = service.findById(id);
        return ResponseEntity.ok().body(time);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Time time){
        Time obj = service.insert(time);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> update(@PathVariable(value = "id") Long id, @RequestBody Time time) {
        time = service.update(id, time);
        return ResponseEntity.ok().body(time);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Time> patch(@PathVariable(value = "id") Long id, @RequestBody Time time) {
        time = service.patch(id, time);
        return ResponseEntity.ok().body(time);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Time> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
