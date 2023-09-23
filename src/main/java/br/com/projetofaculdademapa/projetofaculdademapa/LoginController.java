package br.com.projetofaculdademapa.projetofaculdademapa;


import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author julio
 */
public class LoginController {
     public void CadastrarUsuario(ViewCadastrar view) {
        try {
            Connection conexao = new Conexao().getConnection();
            Cadastrar cadastro = new Cadastrar();
            cadastro.cadastrarUsuario(view.getNome().getText(), view.getLogin().getText(), view.getSenha().getText(), view.getEmail().getText());

            // Sucesso no cadastro
           JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
           view.setVisible(false);
        } catch (SQLException e) {
            // Erro ao cadastrar o usuário
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
            e.printStackTrace(); // Isso imprime o rastreamento da pilha para ajudar a identificar o problema
        }
    }
    
    public void LoginUsuario(ViewLogin view) throws SQLException{
    Connection conexao = new Conexao().getConnection();
        Login login = new Login();
        Usuario usuario = login.LoginUsuario(view.getLogin().getText(), view.getSenha().getText());

        if (usuario == null) {
            // Usuário não encontrado, faça o que for necessário aqui (por exemplo, exiba uma mensagem)
            JOptionPane.showMessageDialog(null, "Acesso negado");
            
        } else {
            // Usuário encontrado, faça o que for necessário aqui (por exemplo, redirecione para outra página)
            JOptionPane.showMessageDialog(null, "Acesso Autorizado");
        }
    }
}
