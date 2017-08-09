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
 * @Since 22/07/2017 , 13:43:14
 */
public class CadastroCarona implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoFactoryIf fabrica = new DaoFactoryBD();
        CaronaDaoIf caronaDao = fabrica.criaCaronaDAO();

        //pegando parametros
        String partida = request.getParameter("partida");
        String destino = request.getParameter("destino");
        String waypoint= request.getParameter("waypoint");
        String dataPartida = request.getParameter("data-partida");
        String horaPartida = request.getParameter("hora-partida");
        String telefone = request.getParameter("telefone");

        Carona carona = new Carona();
        carona.setDestino(destino);
        carona.setOrigem(partida);
        carona.setWayPoint(waypoint);
        carona.setHoraPartida(horaPartida);
        carona.setDataPartida(dataPartida);
        carona.setTelUsuario(telefone);

        if (caronaDao.salvar(carona)) {
            request.setAttribute("sucessoUser", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("sucessoUser", false);
            request.setAttribute("errorMsg", "Não foi possivel inserir a carona");
            RequestDispatcher dispatcher = request.getRequestDispatcher("oferecercarona.jsp");
            dispatcher.forward(request, response);
        }    
    }
}
