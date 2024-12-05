package exercicio21.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Configuração de conexão com o banco de dados.
 */
public class DatabaseConfig {
    private static final String URL = "jdbc:sqlite:loja.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}