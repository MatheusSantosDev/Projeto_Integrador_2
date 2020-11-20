package model;

import connection.connectionFactory;
import connection.connectionFactory_Cybercom;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author higor
 */
public class Produtos_DAO {

    public void create(Produto p) {
        Connection con = connectionFactory_Cybercom.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO produtos(preco,cod_p,nome,descricao,cod_l,qtde) values (?,?,?,?,?,?)");
            stmt.setString(1, p.getpreco());
            stmt.setString(2, p.getcod_P());
            stmt.setString(3, p.getNome());
            stmt.setString(4, p.getdescricao());
            stmt.setString(5, p.getcod_L());
            stmt.setString(6, p.getqtde());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com Sucesso.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory_Cybercom.closeConnection(con, stmt);
        }
    }

    public void delete(Produto p) {
        Connection con = connectionFactory_Cybercom.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from produtos where cod_p=?;");
            stmt.setString(1, p.getcod_P());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory_Cybercom.closeConnection(con, stmt);
        }
    }

    public void update(Produto p) {
        Connection con = connectionFactory_Cybercom.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("update produtos set preco=?,cod_p=?,nome=?, descricao=?,cod_l=?,qtde=? where cod_p=?");
            stmt.setString(1, p.getpreco());
            stmt.setString(2, p.getcod_P());
            stmt.setString(3, p.getNome());
            stmt.setString(4, p.getdescricao());
            stmt.setString(5, p.getcod_L());
            stmt.setString(6, p.getqtde());
            stmt.setString(7, p.getcod_P());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            connectionFactory_Cybercom.closeConnection(con, stmt);
        }
    }

    public ArrayList<Produto> getPesquisa(String pesquisa) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%"+pesquisa+"%\"");              
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Realizar operações" + e.getMessage());
        }
        return Produtos;
    }

    public ArrayList<Produto> getProduto1() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%cooler%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }

    public ArrayList<Produto> getProduto2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%fonte%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }

    public ArrayList<Produto> getProduto3() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%HD%\" or \"%SSD%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }

    public ArrayList<Produto> getProduto4() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%memoria%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }

    public ArrayList<Produto> getProduto5() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%monitor%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }

    public ArrayList<Produto> getProduto6() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%mouse%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }

    public ArrayList<Produto> getProduto7() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%placa de video%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }

    public ArrayList<Produto> getProduto8() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%placa mae%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }

    public ArrayList<Produto> getProduto9() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%processador%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }

    public ArrayList<Produto> getProduto10() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%teclado%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }
    
    public ArrayList<Produto> getPromocao() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> Produtos = new ArrayList<Produto>();
        String categorias [] = {"cooler","fonte","HD","memoria","monitor","mouse","placa de video","placa mae","processador","teclado",};
        int Random = new Random().nextInt(10);
        try {
            conn = connectionFactory_Cybercom.getConnection();
            stmt = conn.prepareStatement("select * from produtos where nome like \"%"+categorias[Random]+"%\"");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto Produto = new Produto();
                Produto.setpreco(rs.getString("preco"));
                Produto.setcod_P(rs.getString("cod_p"));
                Produto.setNome(rs.getString("nome"));
                Produto.setdescricao(rs.getString("descricao"));
                Produto.setcod_L(rs.getString("cod_L"));
                Produto.setqtde(rs.getString("qtde"));
                Produtos.add(Produto);
            }
            connectionFactory_Cybercom.closeConnection(conn, stmt, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }
        return Produtos;
    }
}
