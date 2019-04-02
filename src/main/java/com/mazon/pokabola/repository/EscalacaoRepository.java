package com.mazon.pokabola.repository;

import com.mazon.pokabola.domain.Escalacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscalacaoRepository extends JpaRepository<Escalacao, Long> {

}
