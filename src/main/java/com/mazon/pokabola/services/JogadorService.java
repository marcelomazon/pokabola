package com.mazon.pokabola.services;

import com.mazon.pokabola.domain.Jogador;
import com.mazon.pokabola.repository.JogadorRepository;
import com.mazon.pokabola.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private LocalDateTime datetime = LocalDateTime.now();

    public List<Jogador> findAll() {
        return jogadorRepository.findAll(Sort.by("nome"));
    }

    public Jogador findById(Long id) {
        return jogadorRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Jogador não encontrado ("+id+")"));
    }

    public Jogador insert(Jogador jogador) {
        jogador.setDataCadastro(LocalDateTime.now());
        return jogadorRepository.save(jogador);
    }

    public void delete(Long id){
        Jogador jogador = findById(id);
        jogadorRepository.delete(jogador);
    }

    public Jogador update(Jogador jogador){
        Jogador newJogador = findById(jogador.getId());
        updateJogador(newJogador,jogador);
        return jogadorRepository.save(newJogador);
    }

    private void updateJogador(Jogador newJogador, Jogador jogador) {
        newJogador.setNome(jogador.getNome());
        newJogador.setNumCamisa(jogador.getNumCamisa());
        newJogador.setEmail(jogador.getEmail());
        newJogador.setMedia(jogador.getMedia());
        newJogador.setDataCadastro(LocalDateTime.now());
    }


}
