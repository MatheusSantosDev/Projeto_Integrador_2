/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.connectionFactory_Cybercom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class Comentarios_DAO {
    
    public void create(Comentario c) {
        Connection con = connectionFactory_Cybercom.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO comentarios(palavras) values (?)");
            stmt.setString(1, c.getpalavras());            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Comentado com Sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory_Cybercom.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Comentario> getcomentario() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Comentario> Comentarios = new ArrayList<Comentario>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from comentarios");              
            rs = stmt.executeQuery();
            while (rs.next()) {
                Comentario Comentario = new Comentario();
                Comentario.setpalavras(rs.getString("palavras"));                
                Comentarios.add(Comentario);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Comentar" + e.getMessage());
        }
        return Comentarios;
    }
}
