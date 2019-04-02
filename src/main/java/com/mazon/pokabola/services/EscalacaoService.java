package com.mazon.pokabola.services;

import com.mazon.pokabola.domain.Escalacao;
import com.mazon.pokabola.repository.EscalacaoRepository;
import com.mazon.pokabola.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EscalacaoService {

    @Autowired
    private EscalacaoRepository escalacaoRepository;


    public List<Escalacao> findAll() {
        return escalacaoRepository.findAll(Sort.by("dataCadastro").descending());
    }

    public Escalacao findById(Long id) {
        return escalacaoRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Escalacao não encontrada (" + id + ")"));
    }

    public Escalacao insert(Escalacao escalacao) {
        return escalacaoRepository.save(escalacao);
    }

    public void delete(Long id) {
        Escalacao escalacao = findById(id);
        escalacaoRepository.delete(escalacao);
    }

    public Escalacao update(Escalacao escalacao) {
        Escalacao newEscalacao = findById(escalacao.getId());
        updateEscalacao(newEscalacao, escalacao);
        return escalacaoRepository.save(newEscalacao);
    }

    private void updateEscalacao(Escalacao newEscalacao, Escalacao escalacao) {
        newEscalacao.setJogador(escalacao.getJogador());
        newEscalacao.setDataAtualizacao(LocalDateTime.now());
        newEscalacao.setStatus(escalacao.getStatus());
        newEscalacao.setJogo(escalacao.getJogo());
    }

}
