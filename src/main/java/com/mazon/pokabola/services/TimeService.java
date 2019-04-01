package com.mazon.pokabola.services;

import com.mazon.pokabola.domain.Jogo;
import com.mazon.pokabola.domain.Time;
import com.mazon.pokabola.repository.JogoRepository;
import com.mazon.pokabola.repository.TimeRepository;
import com.mazon.pokabola.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private JogoRepository jogoRepository;

    public List<Time> findAll() {
        return timeRepository.findAll(Sort.by("nome"));
    }

    public Time findById(Long id) {
        return timeRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Time não encontrado ("+id+")"));
    }

    public Time insert(Time time) {
        return timeRepository.save(time);
    }

    public void delete(Long id){
        Time time = findById(id);

        List<Jogo> jogoA = new ArrayList<>();
        List<Jogo> jogoB = new ArrayList<>();

        jogoA = jogoRepository.findByTime1(time.getId());
        jogoB = jogoRepository.findByTime2(time.getId());

        if (jogoA.size() > 0 || jogoB.size() > 0) {
            throw new RuntimeException("Impossível excluir time");
        }

        timeRepository.delete(time);
    }

    public Time update(Time time){
        Time newTime = findById(time.getId());
        updateTime(newTime,time);
        return timeRepository.save(newTime);
    }

    private void updateTime(Time newTime, Time time) {
        newTime.setNome(time.getNome());
    }

}
