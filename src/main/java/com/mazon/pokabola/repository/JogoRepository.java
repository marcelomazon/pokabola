package com.mazon.pokabola.repository;

import com.mazon.pokabola.domain.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    public List<Jogo> findByTime1(Long Id);
    public List<Jogo> findByTime2(Long Id);
}
