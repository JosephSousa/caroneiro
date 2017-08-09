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
 * @Since 15/07/2017 , 19:31:40
 */
public class Login implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        Usuario usuario = new Usuario();
        DaoFactoryIf fabrica = new DaoFactoryBD();
        UsuarioDaoIf usuarioDao = fabrica.criaUsuarioDAO();

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        usuario.setEmail(email);
        usuario.setSenha(senha);
        Usuario usuarioAutenticado = usuarioDao.autenticacao(usuario);
        if (usuarioAutenticado != null) {
            request.setAttribute("sucesso", true);
            request.getSession(true);
            request.getSession().setAttribute("usuarioAutenticado", usuarioAutenticado);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            request.setAttribute("sucesso", false);
            request.setAttribute("errorMsg", "Login ou senha incorretos");
            dispatcher.forward(request, response);
        }
    }
}
