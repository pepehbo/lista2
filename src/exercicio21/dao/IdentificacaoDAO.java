package exercicio21.dao;

import exercicio21.model.Identificacao;
import exercicio21.util.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operações com identificações.
 */
public class IdentificacaoDAO {
    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS identificacao (
                id INTEGER PRIMARY KEY,
                nome TEXT NOT NULL,
                descricao TEXT NOT NULL,
                FOREIGN KEY (id) REFERENCES produto(id)
            )
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela identificacao: " + e.getMessage());
        }
    }

    public boolean inserir(Identificacao identificacao) {
        String sql = "INSERT INTO identificacao (id, nome, descricao) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, identificacao.getId());
            stmt.setString(2, identificacao.getNome());
            stmt.setString(3, identificacao.getDescricao());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir identificação: " + e.getMessage());
            return false;
        }
    }

    public List<Identificacao> listarTodos() {
        List<Identificacao> identificacoes = new ArrayList<>();
        String sql = "SELECT * FROM identificacao";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Identificacao identificacao = new Identificacao();
                identificacao.setId(rs.getInt("id"));
                identificacao.setNome(rs.getString("nome"));
                identificacao.setDescricao(rs.getString("descricao"));
                identificacoes.add(identificacao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar identificações: " + e.getMessage());
        }
        return identificacoes;
    }

    public boolean atualizar(Identificacao identificacao) {
        String sql = "UPDATE identificacao SET nome = ?, descricao = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, identificacao.getNome());
            stmt.setString(2, identificacao.getDescricao());
            stmt.setInt(3, identificacao.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar identificação: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM identificacao WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir identificação: " + e.getMessage());
            return false;
        }
    }
}