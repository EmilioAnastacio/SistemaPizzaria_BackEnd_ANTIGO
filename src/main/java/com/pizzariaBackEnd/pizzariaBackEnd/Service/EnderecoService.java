package com.pizzariaBackEnd.pizzariaBackEnd.Service;

import com.pizzariaBackEnd.pizzariaBackEnd.DTO.EnderecoDTO;
import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Endereco;
import com.pizzariaBackEnd.pizzariaBackEnd.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void cadastrar(EnderecoDTO enderecoDTO){


        this.enderecoRepository.save(toEndereco(enderecoDTO));
    }

    public void editar(Long id, EnderecoDTO enderecoDTO){
        Endereco enderecoBanco = this.enderecoRepository.findById(id).orElse(null);



        Assert.isTrue(enderecoBanco != null, "Endereco nao foi encontrado");
        this.enderecoRepository.save(toEndereco(enderecoDTO));

    }

    public void deletar(Long id){
        Endereco enderecoBanco = this.enderecoRepository.findById(id).orElse(null);

        Assert.isTrue(enderecoBanco != null, "Endereco nao foi encontrado");

        this.enderecoRepository.delete(enderecoBanco);

    }

    public List<EnderecoDTO> findAllEndereco(){
        List<Endereco> enderecoBanco = enderecoRepository.findAll();
        List<EnderecoDTO> enderecoDTOBanco = new ArrayList<>();

        for (int i =0; i < enderecoBanco.size(); i++){
            enderecoDTOBanco.add(toEnderecoDTO(enderecoBanco.get(i)));
        }

        return enderecoDTOBanco;
    }




    public EnderecoDTO toEnderecoDTO(Endereco endereco){
        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setNomeRua(endereco.getNomeRua());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setComplemento(endereco.getComplemento());
        enderecoDTO.setNumero(endereco.getNumero());

        return enderecoDTO;
    }

    public Endereco toEndereco(EnderecoDTO enderecoDTO){
        Endereco endereco = new Endereco();

        endereco.setNomeRua(enderecoDTO.getNomeRua());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setComplemento(enderecoDTO.getComplemento());
        endereco.setNumero(enderecoDTO.getNumero());

        return endereco;
    }


}
