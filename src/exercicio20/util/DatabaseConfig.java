package exercicio20.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitária para configuração e conexão com o banco de dados.
 */
public class DatabaseConfig {
    private static final String URL = "jdbc:sqlite:veiculos.db";

    /**
     * Obtém uma conexão com o banco de dados.
     * @return Conexão com o banco de dados
     * @throws SQLException se houver erro na conexão
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}