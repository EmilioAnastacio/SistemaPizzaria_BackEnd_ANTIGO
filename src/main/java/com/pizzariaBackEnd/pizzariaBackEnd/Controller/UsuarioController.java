package com.pizzariaBackEnd.pizzariaBackEnd.Controller;

import com.pizzariaBackEnd.pizzariaBackEnd.DTO.EnderecoDTO;
import com.pizzariaBackEnd.pizzariaBackEnd.DTO.UsuarioDTO;
import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Usuario;
import com.pizzariaBackEnd.pizzariaBackEnd.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody final UsuarioDTO usuarioDTO){
        try {
            usuarioService.cadastrar(usuarioDTO);
            return ResponseEntity.ok("Usuario, cadastrado com sucesso");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestParam("id") Long id, @RequestBody UsuarioDTO usuarioDTO){
        try {
            usuarioService.editar(id,usuarioDTO);
            return ResponseEntity.ok(usuarioDTO.getNome() + "Alterado com sucesso");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deleta(@RequestParam("id") Long id){
        try {
            usuarioService.deletar(id);
            return ResponseEntity.ok("Deletado com sucesso");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<UsuarioDTO>> findAllUsuario(@RequestBody final UsuarioDTO usuarioDTO){
        try {
            return ResponseEntity.ok(usuarioService.findAllUsuario());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
