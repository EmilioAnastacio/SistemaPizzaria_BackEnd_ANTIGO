import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        int opc = 0;

        do {
            opc = menu();
            System.out.println("\n");
            switch (opc){

                case 1://CADASTRAR PESSOA
                    List<Endereco> enderecos = new ArrayList<>();

                    System.out.println("Digite o nome: ");
                    String nome = scan.next();
                    System.out.println("\nQuantos endereços deseja adicionar?");
                    int qntEndereco = scan.nextInt();

                    for (int i=0; i<qntEndereco; i++){
                        System.out.println("Informações do Endereço\n");
                        System.out.println("Nome da rua: ");
                        String nomeRua = scan.next();
                        System.out.println("Numero da residencia: ");
                        int numero = scan.nextInt();

                        enderecos.add(new Endereco(nomeRua, numero));
                    }

                    clientes.add(new Cliente(nome,enderecos));

                    break;


                case 2://PEDIDO
                    System.out.println("opcao 2");
                    int opcao = 0;

                    do {
                        System.out.println("OPCOES PARA PEDIDOS!");
                        System.out.println("1 - Realizar um pedido");
                        System.out.println("2 - Visualizar todos os pedidos");
                        System.out.println("3 - Visualizar pedidos em andamento");
                        System.out.println("4 - Visualizar pedidos encerrados");
                        System.out.println("5 - sair");
                        System.out.println("Escolha uma opcao");
                        opcao = scan.nextInt();

                        switch (opcao){
                            case 1:
                                realizarPedido(pedidos, clientes, scan);
                                break;
                            case 2:
                                verPedidosTotais(pedidos);
                                break;
                            case 3:
                                verPedidosEmAndamento(pedidos, scan);
                                break;
                            case 4:
                                verPedidosEncerrados(pedidos);
                                break;
                            case 5:
                                System.out.println(" Saindo do Pedido!");
                                break;
                            default:
                                System.out.println("Opcao invalida");
                                break;

                        }

                    }while (opcao != 5);


                    break;

                case 3://LISTA DE CLIENTES
                    for (Cliente cliente: clientes){
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("Enderecos:");
                        for (Endereco endereco: cliente.getEnderecos()){
                            System.out.println("- Rua: " + endereco.getNomeRua());
                            System.out.println("- Numero: " + endereco.getNumero());
                        }
                        System.out.println();
                    }

                    break;

                case 4:
                    System.out.println("digite o nome do cliente que deseja editar: ");
                    String nomeBusca = scan.next();

                    Cliente clienteEncontrado = null;
                    for (Cliente cliente : clientes){
                        if (cliente.getNome().equalsIgnoreCase(nomeBusca)){
                            clienteEncontrado = cliente;
                            break;
                        }
                    }

                    if (clienteEncontrado != null){
                        System.out.println("Cliente Encontrado!");
                        System.out.println("Nome: " + clienteEncontrado.getNome());
                        System.out.println("Endereços:");
                        int indexEndereco = 1;
                        for (Endereco endereco : clienteEncontrado.getEnderecos()){
                            System.out.println("index: " +indexEndereco);
                            System.out.println("- Rua: " + endereco.getNomeRua());
                            System.out.println("- Numero: " + endereco.getNumero());
                            indexEndereco++;
                        }

                        System.out.println("\nOque deseja editar?");
                        System.out.println("1 - nome");
                        System.out.println("2 - endereço");
                        int escolha = scan.nextInt();

                        scan.nextLine(); //pra limpar o buffer

                        if (escolha == 1){
                            System.out.println("Digite um novo nome: ");
                            String nomeNovo = scan.nextLine();
                            clienteEncontrado.setNome(nomeNovo);
                            System.out.println("Nome Atualizado com Sucesso");
                        } else if (escolha == 2) {
                            System.out.println("Digite o index do endereço que deseja editar:");
                            int enderecoIndex = scan.nextInt();
                            scan.nextLine(); //pra limpar o buffer

                            if (enderecoIndex >=1 && enderecoIndex <= clienteEncontrado.getEnderecos().size()){
                                Endereco enderecoSelecionado = clienteEncontrado.getEnderecos().get(enderecoIndex -1);

                                System.out.println("Digite o novo nome da rua:");
                                String novoNomeRua = scan.nextLine();
                                enderecoSelecionado.setNomeRua(novoNomeRua);

                                System.out.println("Digite o novo numero da residencia");
                                int novoNumero = scan.nextInt();
                                enderecoSelecionado.setNumero(novoNumero);

                                System.out.println("\nENDEREÇO ATUALIZADO COM SUCESSO!");
                            } else {
                                System.out.println("Numero de endereço invalido!");
                            }//FIM ELSE ENDERECO INVALIDO

                        }//ELSE IF ESCOLHA 2
                        else {
                            System.out.println("OPCAO INVALIDA!");
                        }
                    }//IF CLIENTE !=null
                    else {
                        System.out.println("Cliete nao encontrado!!!");
                    }

                    break;

                case 5:
                    System.out.println("opcao 4");
                    System.out.println("Lhe aguardo mais tarde <3");
                    break;

                default:
                    System.out.println("opcão invalida, tente novamente.");
                    break;

            }//FIM SWICH CASE

        }while (opc != 5);
        //FIM LOOP MENU


    }//FIM MAIN


    public static int menu(){
        Scanner scan = new Scanner(System.in);

        System.out.println("BEM VINDO A ESTRUTURA BASE DA PIZZARIA");
        System.out.println("SELECIONE UMA OPÇÃO ABAIXO\n\n");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Pedidos");
        System.out.println("3 - Visualizar Clientes");
        System.out.println("4 - Editar Clientes");
        System.out.println("5 - Sair");
        int opc = scan.nextInt();

        return opc;
    }

    private static void realizarPedido(List<Pedido> pedidos, List<Cliente> clientes, Scanner scan){
        System.out.println("Digite o nome do cliente que deseja o pedido: ");
        String buscarNome = scan.next();


        Cliente acheiCliente = null;
        for (Cliente cliente: clientes){
            if (cliente.getNome().equalsIgnoreCase(buscarNome)){
                acheiCliente = cliente;
                System.out.println(cliente);
                break;

            }
        }//fim for acha cliente


        if (acheiCliente != null){
            System.out.println("Digite o nome do pedido: ");
            String nomePedido = scan.next();

            Pedido novoPedido = new Pedido(nomePedido, acheiCliente);
            pedidos.add(novoPedido);

            acheiCliente.addPedido(novoPedido);
            System.out.println("Pedido - " + nomePedido + " - realizado com sucesso");
        }else {
            System.out.println("Cliente nao encontrado.");
        }

    }//FIM FUNCA REALIZA PEDIDO

    private  static void verPedidosTotais(List<Pedido> pedidos){
        System.out.println("Quantidade de pedidos totais: " + pedidos.size());
        for (int i=0; i<pedidos.size(); i++){
            Pedido pedido = pedidos.get(i);
            System.out.println("Index do Pedido: "+ i);
            System.out.println("Nome do pedido: " + pedido.getNome());
            System.out.println("Nome do cliente: " + pedido.getCliente().getNome());
            System.out.println("\n");

        }
    }//FIM VER TODOS PEDIDOS!

    private static void verPedidosEmAndamento(List<Pedido> pedidos, Scanner scan){
        System.out.println("Pedidos em andamento: ");
        for (int i=0; i <pedidos.size();i++){
            Pedido pedido = pedidos.get(i);
            if (!pedido.isEncerrado()){
                System.out.println("Index do pedido: " + i);
                System.out.println("Nome do pedido: " + pedido.getNome());
                System.out.println("Nome do cliente: " + pedido.getCliente().getNome());

            }//fim if !pedido
        }//fim for pedidos.size

        System.out.println("Digite o index do pedido que deseja encerrar: ");
        int indexEncerrar = scan.nextInt();

        if (indexEncerrar >= 0 && indexEncerrar <pedidos.size()){
            Pedido pedidoEncerrar = pedidos.get(indexEncerrar);
            pedidoEncerrar.encerrarPedido();
            System.out.println("Pedido - " + pedidoEncerrar.getNome() + " - encerrado com sucesso!");

            pedidoEncerrar.gerarDocumentoTxt(indexEncerrar);
            System.out.println("Arquivo gerado com sucesso!");

        }else {
            System.out.println("Index Invalido!");
        }
    }//FIM FUNCA VER PEDIDOS EM ANDAMENTO

    private static void verPedidosEncerrados(List<Pedido> pedidos){
        System.out.println("Pedidos encerrados:");
        for (int i=0; i<pedidos.size(); i++){
            Pedido pedido = pedidos.get(i);
            if(pedido.isEncerrado()){
                System.out.println("Index do Pedido: " + i);
                System.out.println("Nome do pedido: " + pedido.getNome());
                System.out.println("Nome do cliente: " + pedido.getCliente().getNome());
            }//fim if pedido.Isencerrado
        }//fim for pedidos.size
    }//FIM FUNCAO VER PEDIDOS ENCERRDOS
}