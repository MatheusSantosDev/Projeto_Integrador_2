package model;

/**
 *
 * @author higor
 */

public class Produto {
    private String preco;
    private String cod_P;    
    private String nome;
    private String descricao;
    private String cod_L;
    private String qtde;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getpreco() {
        return preco;
    }

    public void setpreco(String preco) {
        this.preco = preco;
    }      
    
    public String getcod_P() {
        return cod_P;
    }

    public void setcod_P(String cod_P) {
        this.cod_P = cod_P;
    }      
    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }      
    public String getcod_L() {
        return cod_L;
    }

    public void setcod_L(String cod_L) {
        this.cod_L = cod_L;
    }      
    public String getqtde() {
        return qtde;
    }

    public void setqtde(String qtde) {
        this.qtde = qtde;
    }      
}
