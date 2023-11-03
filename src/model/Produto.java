package model;

public class Produto {
    private Integer id;
    private String nome;
    private float preco;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(String id) {
        if(id == null){
            throw new IllegalArgumentException("O ID não pode ser nulo.");
        }

        try{
            int idNumerico = Integer.parseInt(id);
            if(idNumerico >=0){
                this.id = idNumerico;
            }
            else{
                throw new IllegalArgumentException("O ID não pode ser negativo.");
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("O ID deve ser um número inteiro.");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(String preco) {
        if(preco == null){
            throw new IllegalArgumentException("O preço não pode ser nulo.");
        }

        try{
            float precoNumerico = Float.parseFloat(preco);
            if(precoNumerico >=0){
                this.preco = precoNumerico;
            }
            else{
                throw new IllegalArgumentException("O preço não pode ser negativo.");
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("O preço deve ser um valor numérico.");
        }
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
