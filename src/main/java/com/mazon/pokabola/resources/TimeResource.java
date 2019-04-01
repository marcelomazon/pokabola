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

    @PutMapping
    public ResponseEntity<Time> update(@RequestBody Time time) {
        time = service.update(time);
        return ResponseEntity.ok().body(time);
    }

    @DeleteMapping
    public ResponseEntity<Time> delete(@RequestBody Time time) {
        service.delete(time.getId());
        return ResponseEntity.noContent().build();
    }

}
