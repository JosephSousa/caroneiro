

package com.texugos.caronas.dao;

import com.texugos.caronas.banco.ConexaoBD;
import com.texugos.caronas.classes.Usuario;
import com.texugos.caronas.interfaces.UsuarioDaoIf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 15/07/2017 , 19:08:30
 */
public class UsuarioDao implements UsuarioDaoIf {

    private final ConexaoBD conex = new ConexaoBD();

    private final Connection connection;

    public UsuarioDao() {
        connection = conex.getConnection();
    }

    @Override
    public boolean salvar(Usuario usuario) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT into usuario(nome,telefone,email,senha)"
                    + "VALUES (?,?,?,?)");
            prepareStatement.setString(1, usuario.getNome());
            prepareStatement.setString(2, usuario.getTelefone());
            prepareStatement.setString(3, usuario.getEmail());
            prepareStatement.setString(4, usuario.getSenha());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean remover(Usuario usuario) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM usuario WHERE id=?");
            prepareStatement.setInt(1, usuario.getId());
            prepareStatement.execute();
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("UPDATE usuario set nome=?, email=?,senha=?,telefone=? "
                    + "WHERE id=?");
            prepareStatement.setString(1, usuario.getNome());
            prepareStatement.setString(2, usuario.getEmail());
            prepareStatement.setString(3, usuario.getSenha());
            prepareStatement.setString(4, usuario.getTelefone());
            prepareStatement.setInt(5, usuario.getId());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Usuario> buscarTodos() {
        try {
            List<Usuario> usuarios = new ArrayList<>();

            ResultSet result = consultarTodosOsClientes();

            while (result.next()) {
               usuarios.add(criarUsuario(result));
            }
            return usuarios;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    private ResultSet consultarTodosOsClientes() throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("Select * from usuario");
        ResultSet result = prepareStatement.executeQuery();
        return result;
    }
    
    private Usuario criarUsuario(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        String email=result.getString("email");
        String senha=result.getString("senha");
        String telefone=result.getString("telefone");
        return new Usuario(id, nome, email, senha, telefone);
    }
    
    @Override
    public Usuario autenticacao(Usuario usuario) {
        Usuario usuarioRetorno = null;
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM usuario WHERE email=? and senha=?");
            prepareStatement.setString(1, usuario.getEmail());
            prepareStatement.setString(2, usuario.getSenha());
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                usuarioRetorno = new Usuario();
                usuarioRetorno.setId(result.getInt("id"));
                usuarioRetorno.setNome(result.getString("nome"));
                usuarioRetorno.setEmail(result.getString("email"));
                usuarioRetorno.setTelefone(result.getString("telefone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioRetorno;
    }
}
