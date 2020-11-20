package model;
import connection.connectionFactory;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author higor
 */
public class alunoDAO {
    public void create (aluno p){
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt= con.prepareStatement("INSERT INTO alunos(ra,nome) values (?,?)");
            stmt.setString(1, p.getRa());
            stmt.setString(2, p.getNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            connectionFactory.closeConnection(con,stmt);
        }
    }
    
    public void delete (aluno p){
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt= con.prepareStatement("delete from alunos where ra=?;");
            stmt.setString(1, p.getRa());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            connectionFactory.closeConnection(con,stmt);
        }
    }
    public void update (aluno p){
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt= con.prepareStatement("update alunos set nome=?, ra=? where ra=?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getRa());
            stmt.setString(3, p.getRa());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            connectionFactory.closeConnection(con,stmt);
        }
    }
         
   public ArrayList<aluno> getContatos(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<aluno> alunos = new ArrayList<aluno>();
        try {
            conn = connectionFactory.getConnection();
            stmt = conn.prepareStatement("select * from alunos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                aluno aluno = new aluno(); 
                aluno.setRa(rs.getString("ra"));
                aluno.setNome(rs.getString("nome"));  
                alunos.add(aluno);
            }
            connectionFactory.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return alunos;
    }
}

