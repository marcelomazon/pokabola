package com.mazon.pokabola.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mazon.pokabola.domain.Jogo;
import com.mazon.pokabola.domain.Time;
import com.mazon.pokabola.repository.JogoRepository;
import com.mazon.pokabola.repository.TimeRepository;
import com.mazon.pokabola.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.transaction.annotation.Propagation.NESTED;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;


@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private TimeRepository timeRepository;

    public List<Jogo> findAll() {
        return jogoRepository.findAll(Sort.by("dataJogo").descending());
    }

    @Transactional(propagation = REQUIRED)
    public Jogo findById(Long id) {
        return jogoRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Jogo não encontrado (" + id + ")"));
    }

    public Jogo insert(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public void delete(Long id) {
        Jogo jogo = findById(id);
        jogoRepository.delete(jogo);
    }

    public Jogo update(Jogo jogo) {
        Jogo newJogo = findById(jogo.getId());
        updateJogo(newJogo, jogo);
        return jogoRepository.save(newJogo);
    }

    private void updateJogo(Jogo newJogo, Jogo jogo) {
        newJogo.setLocal(jogo.getLocal());
        newJogo.setDataJogo(jogo.getDataJogo());
        newJogo.setTime1(jogo.getTime1());
        newJogo.setTime2(jogo.getTime2());
    }

}
