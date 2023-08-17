package com.pizzariaBackEnd.pizzariaBackEnd.Service;

import com.pizzariaBackEnd.pizzariaBackEnd.DTO.PedidoDTO;
import com.pizzariaBackEnd.pizzariaBackEnd.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public void cadastrar(final PedidoDTO pedidoDTO){

        Assert.isTrue(pedidoDTO.getIdCliente() == null, "Informe o Cliente");
        Assert.isTrue(pedidoDTO.getIdFuncionario() == null, "Informe o Funcionario");

    }
}
