package com.pizzariaBackEnd.pizzariaBackEnd.Service;

import com.pizzariaBackEnd.pizzariaBackEnd.DTO.ItemDTO;
import com.pizzariaBackEnd.pizzariaBackEnd.Entity.Item;
import com.pizzariaBackEnd.pizzariaBackEnd.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final ItemDTO itemDTO){

        Assert.isTrue(itemDTO.getIdPedido() == null, "Insira um Pedido");
        Assert.isTrue(itemDTO.getTamanho() == null, "Insira um tamanho valido");

        this.itemRepository.save(toItem(itemDTO));
    }

    @Transactional(rollbackFor = Exception.class)
    public void editar(final Long id, final  ItemDTO itemDTO){

        final Item itemBanco = this.itemRepository.findById(id).orElse(null);

        Assert.isTrue(itemDTO.getIdPedido() == null, "Insira um Pedido");
        Assert.isTrue(itemDTO.getTamanho() == null, "Insira um tamanho valido");

        itemBanco.setIdPedido(itemDTO.getIdPedido());
        itemBanco.setTamanho(itemDTO.getTamanho());

        this.itemRepository.save(itemBanco);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deletar(final Long id){

        final Item itemBanco = this.itemRepository.findById(id).orElse(null);
        Assert.isTrue(itemBanco != null, "Registro nao encontrado");
        this.itemRepository.delete(itemBanco);
    }

    public List<ItemDTO> findAllItem(){
        List<Item> itemBanco = itemRepository.findAll();
        List<ItemDTO> itemDTOBanco = new ArrayList<>();

        for (int i=0; i<itemBanco.size();i++){
            itemDTOBanco.add(toItemDTO(itemBanco.get(i)));
        }
        return itemDTOBanco;
    }

    public ItemDTO findByID(Long id){

        Item itemBanco = this.itemRepository.findById(id).orElse(null);
        Assert.isTrue(itemBanco != null, "Item Inválido");
        return toItemDTO(itemBanco);
    }

    public Item toItem(ItemDTO itemDTO){
        Item item = new Item();

        item.setIdPedido(itemDTO.getIdPedido());
        item.setTamanho(itemDTO.getTamanho());
        return item;
    }

    public ItemDTO toItemDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setIdPedido(item.getIdPedido());
        itemDTO.setTamanho(item.getTamanho());
        return itemDTO;
    }
}
