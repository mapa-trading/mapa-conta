package io.github.mapatrading.conta.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", updatable = false, unique = true, nullable = false)
    private UUID id;
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "Email", nullable = false)
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_configuracao",foreignKey = @ForeignKey(name="fk_id_configuracao"),nullable = false)
    private Configuracao configuracao;

}
