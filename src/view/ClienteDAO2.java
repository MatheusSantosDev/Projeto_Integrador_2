/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.connectionFactory;
import connection.connectionFactoryCliente;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author higor
 */
public class ClienteDAO2 {
    public void create (Cliente2 c){
        Connection con = connectionFactoryCliente.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt= con.prepareStatement("INSERT INTO cliente(nome,endereco,foto) values (?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEndereco());
            stmt.setBinaryStream(3, c.getFile());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            connectionFactoryCliente.closeConnection(con,stmt);
        }
    }
    /*public ArrayList<Cliente> getContatos(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("select * from alunos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente2 cliente = new Cliente2(); 
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));  
                cliente.setFile(File.valueof( (rs.getBlob("foto")) );
                cliente.add(cliente);
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return alunos;
    }*/
    
}
