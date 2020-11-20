
package model;

import view.Cliente2;
import connection.connectionFactory_Cybercom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClienteDAO {
    public void create (Cliente c){
        Connection con = connectionFactory_Cybercom.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt= con.prepareStatement("INSERT INTO cliente(nome, telefone, cpf, endereco, cep, email, senha) values (?,?,?,?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getEndereco());
            stmt.setString(5, c.getCep());
            stmt.setString(6, c.getEmail());
            stmt.setString(7, c.getSenha());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            connectionFactory_Cybercom.closeConnection(con,stmt);
        }
    }
    
    public void update (Cliente c){
        Connection con = connectionFactory_Cybercom.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt= con.prepareStatement("update cliente set nome=?,telefone=?,cpf=?, endereco=?,cep=?,email=?, senha=? where cod_cli=?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getCpf());
            stmt.setString(4, c.getEndereco());
            stmt.setString(5, c.getCep());
            stmt.setString(6, c.getEmail());
            stmt.setString(7, c.getSenha());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            connectionFactory_Cybercom.closeConnection(con,stmt);
        }
    }
    
    public ArrayList<Cliente> getPesquisacpf(String pesquisa) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from cliente where cpf like \"%"+pesquisa+"%\"");              
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente Cliente = new Cliente();
                Cliente.setNome(rs.getString("nome"));
                Cliente.setTelefone(rs.getString("telefone"));
                Cliente.setCpf(rs.getString("cpf"));
                Cliente.setEndereco(rs.getString("endereco"));
                Cliente.setCep(rs.getString("cep"));
                Cliente.setEmail(rs.getString("email"));
                Cliente.setSenha(rs.getString("senha"));
                Clientes.add(Cliente);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Clientes" + e.getMessage());
        }
        return Clientes;
    }
}
