package io.github.mapatrading.conta.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Configuracao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Configuracao", updatable = false, unique = true, nullable = false)
    private UUID id;
    @Column(name = "ReceberNotificacoesEmail", nullable = false)
    private Boolean receberNotificacoesEmail;
    @Column(name = "ReceberNotificacoesWhatsApp", nullable = false)
    private Boolean receberNotificacoesWhatsApp;
    @Column(name = "ReceberNotificacoesDispositivo", nullable = false)
    private Boolean recerberNotificacoesDispositivo;

}
