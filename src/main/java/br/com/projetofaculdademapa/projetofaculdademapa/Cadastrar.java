package br.com.projetofaculdademapa.projetofaculdademapa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastrar {

    public Usuario cadastrarUsuario(String nome, String login, String senha, String email)
            throws SQLException {

        // Obtém a conexão com o banco de dados
        Connection conexao = new Conexao().getConnection();
           String sql = "INSERT INTO usuario(nome, login, senha, email) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conexao.prepareStatement(sql);
        Usuario usuario = null;

        // Define o SQL para inserção de um novo usuário
     
        // Prepara o PreparedStatement
        
        statement.setString(1, nome);
        statement.setString(2, login);
        statement.setString(3, senha);
        statement.setString(4, email);

        // Executa o SQL
        int rowsAffected = statement.executeUpdate();

        // Se a inserção foi bem-sucedida, cria um objeto Usuario
        if (rowsAffected > 0) {
            usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setLogin(login);
            usuario.setSenha(senha);
            usuario.setEmail(email);
        }

        // Fecha o statement e a conexão
        if (statement != null) {
            statement.close();
        }
        if (conexao != null) {
            conexao.close();
        }

        return usuario;
    }
}
