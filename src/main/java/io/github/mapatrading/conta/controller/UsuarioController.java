package io.github.mapatrading.conta.controller;

import io.github.mapatrading.conta.Repository.ConfiguracaoRepository;
import io.github.mapatrading.conta.Repository.UsuarioRepository;
import io.github.mapatrading.conta.entity.Configuracao;
import io.github.mapatrading.conta.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuario;

    @GetMapping
    public List<Usuario> listar(){
        return usuario.findAll();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Usuario> post(@RequestBody Usuario user){
        Usuario userSalvo= usuario.save(user);
        return ResponseEntity.ok(userSalvo);
    }



}
