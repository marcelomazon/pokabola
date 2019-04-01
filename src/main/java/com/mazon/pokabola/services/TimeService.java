package com.mazon.pokabola.services;

import com.mazon.pokabola.domain.Time;
import com.mazon.pokabola.repository.JogoRepository;
import com.mazon.pokabola.repository.TimeRepository;
import com.mazon.pokabola.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

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

        if (jogoRepository.qtdJogosByTime(time) > 0L) {
            throw new RuntimeException("Impossível excluir time");
        }

        timeRepository.delete(time);
    }

    public Time update(Long id, Time time){
        findById(id);
        return timeRepository.save(time);
    }

    public Time patch(Long id, Time time){
        Time newTime = findById(id);
        updateTime(newTime,time);
        return timeRepository.save(newTime);
    }

    private void updateTime(Time newTime, Time time) {
        if(nonNull(time.getNome())) {
            newTime.setNome(time.getNome());
        }
    }

}
