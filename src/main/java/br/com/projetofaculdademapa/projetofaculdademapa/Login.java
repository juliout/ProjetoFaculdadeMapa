package br.com.projetofaculdademapa.projetofaculdademapa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author julio
 */
public class Login {
   public Usuario LoginUsuario(String login, String senha ) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT id, nome, login, senha , email from usuario where login = '"+login+"' and senha = '"+login+"'";
        PreparedStatement statment = conexao.prepareStatement(sql);
        ResultSet resultSet = statment.executeQuery();
        Usuario usuario = null;
        if (resultSet.next()) {
            usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setLogin(resultSet.getString("login"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setEmail(resultSet.getString("email"));
        }
        conexao.close();
        return usuario;
    }
}
