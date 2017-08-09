

package com.texugos.caronas.commands;

import com.texugos.caronas.classes.Usuario;
import com.texugos.caronas.factory.DaoFactoryBD;
import com.texugos.caronas.factory.DaoFactoryIf;
import com.texugos.caronas.interfaces.UsuarioDaoIf;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 15/07/2017 , 21:18:42
 */
public class CadastroUsuarios implements Command{
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoFactoryIf fabrica = new DaoFactoryBD();
        UsuarioDaoIf usuarioDao = fabrica.criaUsuarioDAO();

        //pegando parametros
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");
        
        //setando parametros usuario
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setNome(nome);
        usuario.setTelefone(telefone);
    

        if (usuarioDao.salvar(usuario)) {
            request.setAttribute("sucessoUser", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("sucessoUser", false);
            request.setAttribute("errorMsg", "Não foi possivel inserir o usuario");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
