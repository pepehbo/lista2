package exercicio21.dao;

import exercicio21.model.Produto;
import exercicio21.util.DatabaseConfig;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operações com produtos.
 */
public class ProdutoDAO {
    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS produto (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                id_fornecedor INTEGER NOT NULL,
                nome TEXT NOT NULL UNIQUE,
                preco REAL NOT NULL,
                validade DATE NOT NULL,
                FOREIGN KEY (id_fornecedor) REFERENCES fornecedor(id)
            )
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela produto: " + e.getMessage());
        }
    }

    public boolean inserir(Produto produto) {
        String sql = """
            INSERT INTO produto (id_fornecedor, nome, preco, validade)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produto.getIdFornecedor());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setDate(4, Date.valueOf(produto.getValidade()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
            return false;
        }
    }

    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = """
            SELECT p.*, f.nome as fornecedor_nome
            FROM produto p
            JOIN fornecedor f ON p.id_fornecedor = f.id
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setIdFornecedor(rs.getInt("id_fornecedor"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setValidade(rs.getDate("validade").toLocalDate());
                produto.setFornecedorNome(rs.getString("fornecedor_nome"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }

    public List<Produto> listarPorFornecedor(int idFornecedor) {
        List<Produto> produtos = new ArrayList<>();
        String sql = """
            SELECT p.*, f.nome as fornecedor_nome
            FROM produto p
            JOIN fornecedor f ON p.id_fornecedor = f.id
            WHERE p.id_fornecedor = ?
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFornecedor);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setIdFornecedor(rs.getInt("id_fornecedor"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setValidade(rs.getDate("validade").toLocalDate());
                produto.setFornecedorNome(rs.getString("fornecedor_nome"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos por fornecedor: " + e.getMessage());
        }
        return produtos;
    }

    public boolean atualizar(Produto produto) {
        String sql = """
            UPDATE produto 
            SET id_fornecedor = ?, nome = ?, preco = ?, validade = ?
            WHERE id = ?
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produto.getIdFornecedor());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setDate(4, Date.valueOf(produto.getValidade()));
            stmt.setInt(5, produto.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir produto: " + e.getMessage());
            return false;
        }
    }
}