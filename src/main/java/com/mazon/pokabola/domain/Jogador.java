package com.mazon.pokabola.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    @NotEmpty(message = "O nome do jogador é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @Column(name = "nr_camisa", nullable = false, length = 3)
    @NotBlank(message = "O número da camisa do jogador é obrigatório")
    @Size(min=0, max = 3)
    private Integer numCamisa;

    @Column(name = "email", length = 150)
    @Size(max = 100, message = "O e-mail pode ter até 150 caracteres")
    private String email;

    @Column(name = "media", length = 2, precision = 2)
    @Size(max = 3, message = "A média do jogador pode ser de até 2 dígitos e 2 decimais")
    private Float media;

    public Jogador(){}

    public Jogador(Long id, String nome, Integer numCamisa, String email, Float media) {
        this.id = id;
        this.nome = nome;
        this.numCamisa = numCamisa;
        this.email = email;
        this.media = media;
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

    public Integer getNumCamisa() {
        return numCamisa;
    }

    public void setNumCamisa(Integer numCamisa) {
        this.numCamisa = numCamisa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Objects.equals(id, jogador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numCamisa=" + numCamisa +
                '}';
    }
}
