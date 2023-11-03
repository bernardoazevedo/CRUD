package view;

import controller.Controller;
import dto.ProdutoDTO;
import model.Produto;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner input = new Scanner(System.in);
    private Controller controller;

    public void menu(Controller controller){
        this.controller = controller;

        int opcao;

        do{
            System.out.println("\n[1] Novo cadastro");
            System.out.println("[2] Alterar cadastro");
            System.out.println("[3] Excluir cadastro");
            System.out.println("[4] Exibir itens cadastrados");
            System.out.println("[5] Sair do programa");
            System.out.print("Opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    alterar();
                    break;
                case 3:
                    excluir();
                    break;
                case 4:
                    exibirListaDeProdutos();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    input.close();
                    break;
                default:
                    System.out.println("Opção não encontrada, tente novamente.");
            }
        }while(opcao!=5);
    }

    public void cadastrar(){
        String id;
        String nome;
        String preco;
        String descricao;

        System.out.print("\nID: ");
        id = input.nextLine();

        System.out.print("Nome: ");
        nome = input.nextLine();

        System.out.print("Preço: ");
        preco = input.nextLine();

        System.out.print("Descrição: ");
        descricao = input.nextLine();

        controller.cadastrarProduto(id, nome, preco, descricao);
    }

    public void alterar(){
        exibirListaDeProdutos();

        System.out.print("\nDigite o ID do produto que deseja alterar: ");
        String id = input.nextLine();

        System.out.print("\nNovo nome: ");
        String nome = input.nextLine();

        System.out.print("Novo preço: ");
        String preco = input.nextLine();

        System.out.print("Nova descrição: ");
        String descricao = input.nextLine();

        controller.alterarCadastro(id, nome, preco, descricao);
    }

    public void excluir(){
        exibirListaDeProdutos();

        System.out.println("\nDigite o ID do produto que deseja excluir: ");
        String id = input.nextLine();

        controller.excluirProduto(id);
    }

    public void exibeProduto(ProdutoDTO produto){
        System.out.println("ID: " + produto.getId());
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: " + produto.getPreco());
        System.out.println("Descrição: " + produto.getDescricao());
    }

    public void exibirListaDeProdutos(){
        List<ProdutoDTO> produtos = controller.getProdutos();

        for(ProdutoDTO produto : produtos){
            System.out.print("\n--> ");
            exibeProduto(produto);
        }
    }

    public void mensagemDeSucesso(String mensagem){
        System.out.println("SUCESSO: " + mensagem);
    }

    public void mensagemDeErro(String mensagem){
        System.out.println("ERRO: " + mensagem);
    }
}
