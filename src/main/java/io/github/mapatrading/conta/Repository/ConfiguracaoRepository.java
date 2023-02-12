package io.github.mapatrading.conta.Repository;

import io.github.mapatrading.conta.entity.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, UUID> {
}
