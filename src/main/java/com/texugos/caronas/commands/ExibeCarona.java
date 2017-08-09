package com.texugos.caronas.commands;

import com.texugos.caronas.classes.Carona;
import com.texugos.caronas.factory.DaoFactoryBD;
import com.texugos.caronas.factory.DaoFactoryIf;
import com.texugos.caronas.interfaces.CaronaDaoIf;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 05/08/2017 , 22:28:15
 */
public class ExibeCarona implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Carona carona=new Carona();
        DaoFactoryIf fabrica = new DaoFactoryBD();
        CaronaDaoIf caronaDao = fabrica.criaCaronaDAO();
        //pegando parametros
        int id = Integer.parseInt(request.getParameter("id-carona"));
        carona.setId(id);
        
        Carona carona2 = caronaDao.buscaPorId(carona);
        if (carona2 != null) {
            request.setAttribute("carona", carona2);
            RequestDispatcher dispatcher = request.getRequestDispatcher("exibircarona.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("sucessoUser", false);
            request.setAttribute("errorMsg", "Não foi possivel inserir a carona");
            RequestDispatcher dispatcher = request.getRequestDispatcher("oferecercarona.jsp");
            dispatcher.forward(request, response);
        }
    }

}
