package io.github.mapatrading.conta.controller;

import io.github.mapatrading.conta.Repository.ConfiguracaoRepository;
import io.github.mapatrading.conta.entity.Configuracao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static io.github.mapatrading.conta.Repository.ConfiguracaoRepository.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/configuracao")
public class ConfiguracaoController {


    @Autowired
    ConfiguracaoRepository configuracao;

    @GetMapping
    public List<Configuracao> listar() {
        return configuracao.findAll();
    }

    @PostMapping
    @ResponseBody //O que vai retornar;
    public ResponseEntity save(@RequestBody Configuracao config) {
        Configuracao configuracaoSalva = configuracao.save(config);
        return ResponseEntity.ok(configuracaoSalva);
    }


}
