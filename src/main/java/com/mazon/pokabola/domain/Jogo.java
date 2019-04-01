package com.mazon.pokabola.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "jogo")
public class Jogo implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "dt_jogo")
    LocalDateTime dataJogo;

    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "time1_id", nullable = false)
    @JsonManagedReference
    private Time time1;

    @ManyToOne//(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "time2_id", nullable = false)
    @JsonManagedReference
    private Time time2;

    @Column(name = "local",length = 50)
    private String local;

    public Jogo() {
    }

    public Jogo(Long id, LocalDateTime dataJogo, Time time1, Time time2, String local) {
        this.id = id;
        this.dataJogo = dataJogo;
        this.time1 = time1;
        this.time2 = time2;
        this.local = local;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(LocalDateTime dataJogo) {
        this.dataJogo = dataJogo;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return Objects.equals(id, jogo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", dataJogo=" + dataJogo +
                ", time1=" + time1.toString() +
                ", time2=" + time2.toString() +
                ", local='" + local + '\'' +
                '}';
    }
}

