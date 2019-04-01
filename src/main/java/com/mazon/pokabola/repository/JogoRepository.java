package com.mazon.pokabola.repository;

import com.mazon.pokabola.domain.Jogo;
import com.mazon.pokabola.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    //@Query(value = "SELECT CASE WHEN (SELECT j.id FROM jogo j WHERE j.time1_id = ?1 OR j.time2_id = ?1) = 1 THEN true ELSE false END", nativeQuery = true)
    @Query("SELECT count(j.id) FROM Jogo j WHERE j.time1 = ?1 OR j.time2 = ?1")
    public Long qtdJogosByTime(Time time);
}
