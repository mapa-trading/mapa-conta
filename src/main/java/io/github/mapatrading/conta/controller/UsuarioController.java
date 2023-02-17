package io.github.mapatrading.conta.controller;

import io.github.mapatrading.conta.Repository.UsuarioRepository;
import io.github.mapatrading.conta.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuario;

    @GetMapping
    public List<Usuario> get() {
        return usuario.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> get(@PathVariable UUID id) {
        Optional<Usuario> user = usuario.findById(id);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody @Valid Usuario user) {
        Usuario userSalvo = usuario.save(user);
        return ResponseEntity.ok(userSalvo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        Optional<Usuario> user = usuario.findById(id);

        if (user.isPresent()) {
            usuario.delete(user.get());
            return ResponseEntity.noContent().build();
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable UUID id,
                                 @RequestBody Usuario user) {
        return usuario.findById(id)
                      .map(UsuarioExistente-> {
                          user.setId(UsuarioExistente.getId());
                          usuario.save(user);
                          return ResponseEntity.noContent().build();
                      }).orElseGet(()->ResponseEntity.noContent().build());
    }

}
