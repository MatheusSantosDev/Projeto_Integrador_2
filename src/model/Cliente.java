package model;

public class Cliente {

    private String Nome;
    private String Telefone;
    private String Cpf;
    private String Endereco;
    private String Cep;
    private String Email;
    private String Senha;

    public String getNome() {
        return Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public String getCpf() {
        return Cpf;
    }

    public String getEndereco() {
        return Endereco;
    }

    public String getCep() {
        return Cep;
    }

    public String getEmail() {
        return Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
  
}
