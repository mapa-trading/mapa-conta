package io.github.mapatrading.conta.entity;

import com.fasterxml.jackson.databind.JsonDeserializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.CascadeType;
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
public class Usuario  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", updatable = false, nullable = false)
    @ApiModelProperty(value = "Id do usuario", hidden = true)
    private UUID id;
    @Column(name = "nome", nullable = false)
    @NotEmpty(message="Campo nome é obrigátorio")
    private String nome;

    @Column(name = "Email", nullable = false)
    @NotEmpty(message="Campo nome é obrigátorio")
    private String email;
    @Column(name = "ReceberNotificacoesEmail", nullable = false)
    @NotNull(message="Campo Receber email é obrigátorio")
    private Boolean receberNotificacoesEmail;
    @Column(name = "ReceberNotificacoesWhatsApp", nullable = false)
    @NotNull(message="Campo Receber Whatsapp é obrigátorio")
    private Boolean receberNotificacoesWhatsApp;
    @Column(name = "ReceberNotificacoesDispositivo", nullable = false)
    @NotNull(message="Campo Receber Dispositivo é obrigátorio")
    private Boolean recerberNotificacoesDispositivo;
}
