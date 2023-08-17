package com.pizzariaBackEnd.pizzariaBackEnd.Service;

import com.pizzariaBackEnd.pizzariaBackEnd.DTO.PedidoDTO;
import com.pizzariaBackEnd.pizzariaBackEnd.DTO.UsuarioDTO;
import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Pedido;
import com.pizzariaBackEnd.pizzariaBackEnd.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final PedidoDTO pedidoDTO){

        Assert.isTrue(pedidoDTO.getIdCliente() == null, "Informe o Cliente");
        Assert.isTrue(pedidoDTO.getIdFuncionario() == null, "Informe o Funcionario");
        Assert.isTrue(pedidoDTO.getNome() == null, "Informe o nome do Pedido");
        Assert.isTrue(pedidoDTO.getDelivery() == null, "Informe o Delivery(true/false)");
        Assert.isTrue(pedidoDTO.getEstado() == null, "Informe o Estado");

        this.pedidoRepository.save(toPedido(pedidoDTO));

    }

    @Transactional(rollbackFor = Exception.class)
    public void editar(final Long id, final PedidoDTO pedidoDTO){

        final Pedido pedidoBanco = this.pedidoRepository.findById(id).orElse(null);

        Assert.isTrue(pedidoDTO.getIdCliente() == null, "Informe o Cliente");
        Assert.isTrue(pedidoDTO.getIdFuncionario() == null, "Informe o Funcionario");
        Assert.isTrue(pedidoDTO.getNome() == null, "Informe o nome do Pedido");
        Assert.isTrue(pedidoDTO.getDelivery() == null, "Informe o Delivery(true/false)");
        Assert.isTrue(pedidoDTO.getEstado() == null, "Informe o Estado");

        pedidoBanco.setNome(pedidoDTO.getNome());
        pedidoBanco.setIdCliente(pedidoDTO.getIdCliente());
        pedidoBanco.setIdFuncionario(pedidoDTO.getIdFuncionario());
        pedidoBanco.setDelivery(pedidoDTO.getDelivery());
        pedidoBanco.setEstado(pedidoDTO.getEstado());

        this.pedidoRepository.save(pedidoBanco);

    }

    public List<PedidoDTO> findAllPedido(){
        List<Pedido> pedidoBanco = pedidoRepository.findAll();
        List<PedidoDTO> pedidoDTOBanco = new ArrayList<>();

        for (int i=0;i<pedidoDTOBanco.size();i++){
            pedidoDTOBanco.add(toPedidoDTO(pedidoBanco.get(i)));
        }

        return pedidoDTOBanco;
    }

    public void deletar(final Long id){

        final Pedido pedidoBanco = this.pedidoRepository.findById(id).orElse(null);

        Assert.isTrue(pedidoBanco != null, "Registro não encontrado");

        this.pedidoRepository.delete(pedidoBanco);

    }


    public Pedido toPedido(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();

        pedido.setNome(pedidoDTO.getNome());
        pedido.setIdCliente(pedidoDTO.getIdCliente());
        pedido.setIdFuncionario(pedidoDTO.getIdFuncionario());
        pedido.setDelivery(pedidoDTO.getDelivery());
        pedido.setEstado(pedidoDTO.getEstado());

        return pedido;
    }

    public PedidoDTO toPedidoDTO(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setNome(pedido.getNome());
        pedidoDTO.setIdCliente(pedido.getIdCliente());
        pedidoDTO.setIdFuncionario(pedido.getIdFuncionario());
        pedidoDTO.setDelivery(pedido.getDelivery());
        pedidoDTO.setEstado(pedido.getEstado());

        return pedidoDTO;
    }
}
