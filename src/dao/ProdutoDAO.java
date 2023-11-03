package dao;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private List<Produto> produtos = new ArrayList<>();

    public boolean create(Produto produto){
        return produtos.add(produto);
    }

    public Produto read(int id){
        //passa pela lista e se encontrar o ID inserido, retorna o produto
        for(Produto produto : produtos){
            if(produto.getId() == id){
                return produto;
            }
        }

        return null; //se não encontrar, retorna null
    }

    public boolean update(Produto produto){
        for(int i=0; i<produtos.size(); i++){ //roda enquanto i for menor que o tamanho da lista

            //pega o id do elemento i da lista e compara com o id do produto
            //se for igual, atualiza o produto e retorna true
            if(produtos.get(i).getId() == produto.getId()){
                produtos.set(i, produto);
                return true;
            }
        }

        return false; //não encontrou o produto
    }

    public boolean delete(Produto produto){
        for(int i=0; i<produtos.size(); i++){ //roda enquanto i for menor que o tamanho da lista

            //pega o id do elemento i da lista e compara com o id do produto
            //se for igual, deleta o produto e retorna true
            if(produtos.get(i).getId() == produto.getId()){
                produtos.remove(produto);
                return true;
            }
        }

        return false; //não encontrou o produto
    }

    public List<Produto> getProdutos(){
        return produtos;
    }



}
