package com.pizzariaBackEnd.pizzariaBackEnd.Service;

import com.pizzariaBackEnd.pizzariaBackEnd.DTO.UsuarioDTO;
import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Usuario;
import com.pizzariaBackEnd.pizzariaBackEnd.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //POST!
    @Transactional(rollbackFor = Exception.class)
    public UsuarioDTO cadastrar(final UsuarioDTO usuarioDTO){

        Assert.isTrue(usuarioDTO.getNome() ==  null, "Insira um nome!");
        Assert.isTrue(usuarioDTO.getTelefone() == null, "Insira um telefone válido");
        Assert.isTrue(usuarioDTO.getCpf() == null, "Insira um Cpf válido");
        Assert.isTrue(usuarioDTO.getEnderecos() == null, "Insira um Endereço válido");

        return toUsuarioDTO(usuarioRepository.save(toUsuario(usuarioDTO)));
    }

    @Transactional(rollbackFor = Exception.class)
    public UsuarioDTO editar(final Long id, final UsuarioDTO usuarioDTO){

        final Usuario usuarioBanco = this.usuarioRepository.findById(usuarioDTO.getId()).orElse(null);

        Assert.isTrue(usuarioBanco != null || usuarioDTO.getId().equals(id), "Registro não encontrado");
        Assert.isTrue(usuarioDTO.getId() == null, "Insira um ID!");
        Assert.isTrue(usuarioDTO.getNome() == null, "Insira um nome");
        Assert.isTrue(usuarioDTO.getTelefone() == null, "Insira um telefone válido");
        Assert.isTrue(usuarioDTO.getCpf() == null, "Insira um CPF válido");
        Assert.isTrue(usuarioDTO.getEnderecos() == null, "Insira um Endereço");

        return toUsuarioDTO(usuarioRepository.save(toUsuario(usuarioDTO)));
    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(final Long id){

        final Usuario usuarioBanco = this.usuarioRepository.findById(id).orElse(null);

        Assert.isTrue(usuarioBanco != null, "Registro não encontrado");

        this.usuarioRepository.delete(usuarioBanco);

    }

    public Usuario toUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setEnderecos(usuarioDTO.getEnderecos());
        return usuario;

    }

    public UsuarioDTO toUsuarioDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setTelefone(usuario.getTelefone());
        usuarioDTO.setCpf(usuario.getCpf());
        usuario.setEnderecos(usuario.getEnderecos());
        return usuarioDTO;
    }


}
