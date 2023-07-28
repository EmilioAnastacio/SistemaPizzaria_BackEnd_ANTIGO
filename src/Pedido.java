import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Pedido {

    private String nome;
    private Cliente cliente;
    private boolean encerrado;

    public Pedido(String nome, Cliente cliente) {
        this.nome = nome;
        this.cliente = cliente;
        this.encerrado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEncerrado() {
        return encerrado;
    }

    public void setEncerrado(boolean encerrado) {
        this.encerrado = encerrado;
    }

    public void encerrarPedido(){
        this.encerrado = true;
    }

    public void gerarDocumentoTxt(int indexPedido){
        System.out.println("ENTROU!");
        String nomeArquivo = "Pedido_" + indexPedido + ".txt";

        try(PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))){
            writer.println("Nome do Pedido: " + this.nome);
            writer.println("Index do Pedido: " + indexPedido);
            writer.println("Nome do CLiente: "+ this.cliente.getNome());
            writer.println("Endereço do Cliente: ");
            for (Endereco endereco : this.cliente.getEnderecos()){
                writer.println("- " + endereco.getNomeRua());
                writer.println("- " + endereco.getNumero());
            }
            writer.flush();
            System.out.println("Arquivo " + nomeArquivo + " gerado com sucesso!");
        }catch (IOException e){
            System.out.println("Erro ao gerar o documento .txt do pedido: " + e.getMessage());
        }
    }
}
