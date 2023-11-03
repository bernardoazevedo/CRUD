package dto;

public class ProdutoDTO {
    private Integer  id;
    private String nome;
    private float preco;
    private String descricao;

    public ProdutoDTO(Integer id, String nome, float preco, String descricao){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Integer getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public float getPreco(){
        return preco;
    }

    public String getDescricao(){
        return descricao;
    }
}
