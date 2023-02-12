package io.github.mapatrading.conta.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id_Usuario", updatable = false,unique = true,nullable = false)
    private UUID id;
    @Column(name="nome",nullable = false)
    private String nome;

    @Column(name="Email",nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_configuracao",foreignKey = @ForeignKey(name="fk_id_configuracao"),nullable = false)
    private Configuracao configuracao;

}
