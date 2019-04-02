package com.mazon.pokabola.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "time", uniqueConstraints = {@UniqueConstraint(columnNames={"nome"}, name="uk_nome_time")})
public class Time implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    @NotEmpty(message = "O nome do time é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome do time ter entre 3 e 50 caracteres")
    private String nome;

    public Time() {
    }

    public Time(Long id, @NotEmpty(message = "O nome do time é obrigatório.") @Size(min = 3, max = 50, message = "O nome do time ter entre 3 e 50 caracteres") String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(id, time.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

