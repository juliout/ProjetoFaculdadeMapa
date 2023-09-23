package br.com.projetofaculdademapa.projetofaculdademapa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/mapa"; //COLOCAR SUA CONEXÃO AQUI
    private static final String USUARIO = "";// COLOCAR O USUARIO AQUI
    private static final String SENHA = ""; //COLOCAR SUA SENHA AQUI
    
    // O SCHEMA E A TABELA FOI CRIADO POR FORA, USANDO COMANDO NO MYSQL.
    
    public Connection getConnection() throws SQLException {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
        
        return conexao;
    }
}
