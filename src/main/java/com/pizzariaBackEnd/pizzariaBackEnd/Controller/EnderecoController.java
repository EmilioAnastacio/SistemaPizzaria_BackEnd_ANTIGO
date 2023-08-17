package com.pizzariaBackEnd.pizzariaBackEnd.Controller;

import com.pizzariaBackEnd.pizzariaBackEnd.DTO.EnderecoDTO;
import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Endereco;
import com.pizzariaBackEnd.pizzariaBackEnd.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody final EnderecoDTO enderecoDTO){
        try {
            enderecoService.cadastrar(enderecoDTO);
            return  ResponseEntity.ok("Endereço, cadastrado com sucesso");

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestParam("id") Long id, @RequestBody EnderecoDTO enderecoDTO){
        try{
            enderecoService.editar(id,enderecoDTO);
            return ResponseEntity.ok(enderecoDTO.getUsuario() + "Alterado com sucesso");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deleta(@RequestParam("id") Long id){
        try {
            enderecoService.deletar(id);
            return ResponseEntity.ok("Deletado com sucesso");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @GetMapping("/list")
    public ResponseEntity<List<EnderecoDTO>> findAllEndereco(@RequestBody final EnderecoDTO enderecoDTO){
        try {
            return ResponseEntity.ok(enderecoService.findAllEndereco());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
