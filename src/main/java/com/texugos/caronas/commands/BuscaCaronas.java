

package com.texugos.caronas.commands;

import com.texugos.caronas.classes.Carona;
import com.texugos.caronas.factory.DaoFactoryBD;
import com.texugos.caronas.factory.DaoFactoryIf;
import com.texugos.caronas.interfaces.CaronaDaoIf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 08/08/2017 , 03:01:21
 */
public class BuscaCaronas implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Carona> lista= new ArrayList<>();
        Carona carona=new Carona();
        DaoFactoryIf fabrica = new DaoFactoryBD();
        CaronaDaoIf caronaDao = fabrica.criaCaronaDAO();
        //pegando parametros
        String origem = request.getParameter("pesquisa-origem");
        String destino = request.getParameter("pesquisa-destino");
        carona.setOrigem(origem);
        carona.setDestino(destino);
        
         lista = caronaDao.buscarPorLocal(carona);
        if (lista != null) {
            request.setAttribute("caronas", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("pedircarona.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("sucessoUser", false);
            request.setAttribute("errorMsg", "Não foi possivel inserir a carona");
            RequestDispatcher dispatcher = request.getRequestDispatcher("oferecercarona.jsp");
            dispatcher.forward(request, response);
        }
    }

}
