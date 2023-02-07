package io.github.mapatrading.conta.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Usuario {
    private UUID id;
    private String nome;
    private String email;

    private Configuracao configuracao;

}
