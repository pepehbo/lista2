package exercicio20.dao;

import exercicio20.model.Veiculo;
import exercicio20.util.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO para operações de CRUD de veículos no banco de dados.
 */
public class VeiculoDAO {
    /**
     * Cria a tabela de veículos se não existir.
     */
    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS veiculos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                marca TEXT NOT NULL,
                modelo TEXT NOT NULL,
                numero_chassi TEXT UNIQUE NOT NULL,
                placa TEXT UNIQUE NOT NULL,
                cor TEXT NOT NULL
            )
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    /**
     * Insere um novo veículo no banco de dados.
     * @param veiculo Veículo a ser inserido
     * @return true se inserido com sucesso, false caso contrário
     */
    public boolean inserir(Veiculo veiculo) {
        String sql = """
            INSERT INTO veiculos (marca, modelo, numero_chassi, placa, cor)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getNumeroChassi());
            stmt.setString(4, veiculo.getPlaca());
            stmt.setString(5, veiculo.getCor());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir veículo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Consulta todos os veículos cadastrados.
     * @return Lista de veículos
     */
    public List<Veiculo> listarTodos() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getInt("id"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setNumeroChassi(rs.getString("numero_chassi"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setCor(rs.getString("cor"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar veículos: " + e.getMessage());
        }
        return veiculos;
    }

    /**
     * Atualiza um veículo existente.
     * @param veiculo Veículo com as novas informações
     * @return true se atualizado com sucesso, false caso contrário
     */
    public boolean atualizar(Veiculo veiculo) {
        String sql = """
            UPDATE veiculos 
            SET marca = ?, modelo = ?, numero_chassi = ?, placa = ?, cor = ?
            WHERE id = ?
        """;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getNumeroChassi());
            stmt.setString(4, veiculo.getPlaca());
            stmt.setString(5, veiculo.getCor());
            stmt.setInt(6, veiculo.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar veículo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Exclui um veículo pelo ID.
     * @param id ID do veículo a ser excluído
     * @return true se excluído com sucesso, false caso contrário
     */
    public boolean excluir(int id) {
        String sql = "DELETE FROM veiculos WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir veículo: " + e.getMessage());
            return false;
        }
    }
}