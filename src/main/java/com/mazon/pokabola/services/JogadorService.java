package com.mazon.pokabola.services;

import com.mazon.pokabola.domain.Jogador;
import com.mazon.pokabola.repository.JogadorRepository;
import com.mazon.pokabola.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public List<Jogador> findAll() {
        return jogadorRepository.findAll(Sort.by("nome"));
    }

    public Jogador findById(Long id) {
        return jogadorRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Jogador não encontrado ("+id+")"));
    }

    public Jogador insert(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public void delete(Long id){
        Jogador jogador = findById(id);
        jogadorRepository.delete(jogador);
    }

    public Jogador update(Jogador jogador){
        Jogador newJogador = findById(jogador.getId());
        updateData(newJogador,jogador);
        return jogadorRepository.save(newJogador);
    }

    private void updateData(Jogador newJogador, Jogador jogador) {
        newJogador.setNome(jogador.getNome());
        newJogador.setEmail(jogador.getEmail());
    }


}
