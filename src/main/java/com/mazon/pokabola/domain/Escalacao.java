package com.mazon.pokabola.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "escalacao")
public class Escalacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
    //@JsonManagedReference
    private Jogo jogo;

    @ManyToOne
    @JoinColumn(name = "jogador_id", nullable = false)
    //@JsonManagedReference
    private Jogador jogador;

    @Column(name = "status", nullable = false, length = 1)
    private EscalacaoStatus status = EscalacaoStatus.PENDENTE;

    @Column(name = "dt_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    public Escalacao(){}

    public Escalacao(Long id, Jogo jogo, Jogador jogador, EscalacaoStatus status, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.jogo = jogo;
        this.jogador = jogador;
        this.status = status;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public EscalacaoStatus getStatus() {
        return status;
    }

    public void setStatus(EscalacaoStatus status) {
        this.status = status;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escalacao escalacao = (Escalacao) o;
        return id.equals(escalacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Escalacao{" +
                "id=" + id +
                ", jogo=" + jogo +
                ", jogador=" + jogador +
                ", status=" + status +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
