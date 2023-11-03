package controller;

import dao.ProdutoDAO;
import dto.ProdutoDTO;
import model.Produto;
import view.View;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private ProdutoDAO produtoDAO;
    private View view;

    public Controller(View view){
        produtoDAO = new ProdutoDAO();
        this.view = view;
    }

    public void cadastrarProduto(String id, String nome, String preco, String descricao){
        //instancia um produto e tenta armazenar, se der erro, é passado para a view exibir
        try{
            //verifica se o id inserido já está em uso. Se estiver, lança uma exceção
            int idProcurado = Integer.parseInt(id);
            Produto prodAux = produtoDAO.read(idProcurado);
            if(prodAux != null){
                throw new Exception("O ID:" + id + " já está em uso. O ID deve ser único para cada produto.");
            }


            //o id não está sendo usado, logo preenche o modelo e tenta inserir na lista
            Produto produto = new Produto();
            produto.setId(id);
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setDescricao(descricao);

            if(!produtoDAO.create(produto)){ //se retornar false, o produto não foi cadastrado
                throw new Exception("Não foi possível cadastrar o produto.");
            }
            else{ //se retornar true, o produto foi cadastrado
                passaSucessoParaView("Produto cadastrado com sucesso.");
            }
        }
        catch(Exception e){
            //passa o erro para a view exibir
            passaErroParaView(e.getMessage());
        }
    }

    public Produto procuraProduto(String id){
        try{
            //transforma o id digitado em int e procura o produto na lista
            int idProcurado = Integer.parseInt(id);
            Produto produtoProcurado = produtoDAO.read(idProcurado);

            if(produtoProcurado != null){
                //encontrou, retorna o produto
                return produtoProcurado;
            }
            else{
                //não encontrou, informa a mensagem de erro
                throw new Exception("Produto ID:" + id + " não foi encontrado.");
            }
        }
        catch (Exception e) {
            passaErroParaView(e.getMessage());
        }

        return null; //caso não seja encontrado, retorna null
    }

    public void alterarCadastro(String id, String nome, String preco, String descricao){
        try{
            //procura o produto na lista
            Produto produto = procuraProduto(id);

            if(produto != null){
                //o retorno não foi nulo, então o produto foi encontrado e retornado
                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setDescricao(descricao);

                //tenta atualizar o cadastro do produto
                if(produtoDAO.update(produto)){
                    passaSucessoParaView("Produto atualizado com sucesso.");
                }
                else{
                    passaErroParaView("Não foi possível atualizar os dados do produto.");
                }
            }
        }
        catch (Exception e){
            passaErroParaView(e.getMessage());
        }
    }

    public void excluirProduto(String id){
        try {
            //procura o produto na lista
            Produto produto = procuraProduto(id);

            if(produto != null) {
                //o retorno não foi nulo, então o produto foi encontrado e retornado

                if(produtoDAO.delete(produto)){
                    passaSucessoParaView("Produto excluído com sucesso.");
                }
                else{
                    passaErroParaView("Não foi possível excluir o produto.");
                }
            }
        } catch (Exception e) {
            passaErroParaView(e.getMessage());
        }
    }

    public List<ProdutoDTO> getProdutos(){
        List<Produto> produtos = produtoDAO.getProdutos();
        List<ProdutoDTO> produtosDTO = new ArrayList<>();

        for(Produto produto : produtos){
            ProdutoDTO prodDTO = new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco(), produto.getDescricao());
            produtosDTO.add(prodDTO);
        }

        return produtosDTO;
    }

    public void passaSucessoParaView(String mensagem){
        view.mensagemDeSucesso(mensagem);
    }

    public void passaErroParaView(String mensagem){
        view.mensagemDeErro(mensagem);
    }

}
