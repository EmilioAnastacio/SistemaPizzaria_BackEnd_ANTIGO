import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;

    private List<Endereco> enderecos;

    private List<Pedido> pedidos;

     public Cliente(){

     }

    public Cliente(String nome, List<Endereco> enderecos) {
        this.nome = nome;
        this.enderecos = enderecos;
        this.pedidos = new ArrayList<>();
    }

    public void addPedido(Pedido pedido){
         pedidos.add(pedido);
    }

    public List<Pedido> getPedidos(){
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
