package com.mazon.pokabola.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "jogador", uniqueConstraints = {@UniqueConstraint(columnNames={"email"}, name="uk_email_jogador")})
public class Jogador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    @NotEmpty(message = "O nome do jogador é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @Column(name = "nr_camisa", nullable = false, length = 3)
    @NotNull(message = "O número da camisa é obrigatório")
    @Digits(message="O número da camisa é inválido.", integer=3, fraction = 0)
    @Min(value = 1, message = "O número da camisa deve ser maior que zero")
    private Integer numCamisa;

    @Column(name = "email", length = 150)
    @Size(max = 100, message = "O e-mail pode ter até 150 caracteres")
    @Email(message = "O e-mail é inválido")
    private String email;

    @Column(name = "media", precision = 4, scale = 2, columnDefinition="DECIMAL(4,2)")
    @Digits(message="A média é inválida.", integer=2, fraction = 2)
    private Float media;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
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
                ", email='" + email + '\'' +
                ", media=" + media +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
