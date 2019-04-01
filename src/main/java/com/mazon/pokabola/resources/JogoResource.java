package com.mazon.pokabola.resources;

import com.mazon.pokabola.domain.Jogo;
import com.mazon.pokabola.domain.Time;
import com.mazon.pokabola.services.JogoService;
import com.mazon.pokabola.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoResource {

    @Autowired
    private JogoService service;

    @Autowired
    private TimeService timeService;

    @GetMapping
    public ResponseEntity<List<Jogo>> findAll(){
        List<Jogo> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> findById(@PathVariable(value = "id") Long id){
        Jogo time = service.findById(id);
        return ResponseEntity.ok().body(time);
    }

    @GetMapping("/{id}/time/{time}")
    public ResponseEntity<Time> findTimeById(@PathVariable(value = "id") Long id,
                                             @PathVariable(value = "time") Long idTime){
         Time time = timeService.findById(idTime);
        return ResponseEntity.ok().body(time);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Jogo jogo){
        Jogo obj = service.insert(jogo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping
    public ResponseEntity<Jogo> update(@RequestBody Jogo jogo) {
        jogo = service.update(jogo);
        return ResponseEntity.ok().body(jogo);
    }

}
