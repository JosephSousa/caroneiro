package com.texugos.caronas.dao;

import com.texugos.caronas.banco.ConexaoBD;
import com.texugos.caronas.classes.Carona;
import com.texugos.caronas.interfaces.CaronaDaoIf;
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
 * @Since 22/07/2017 , 13:17:28
 */
public class CaronaDao implements CaronaDaoIf {

    private final ConexaoBD conex = new ConexaoBD();

    private final Connection connection;

    public CaronaDao() {
        connection = conex.getConnection();
    }

    @Override
    public boolean salvar(Carona carona) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT into carona(origem,destino,waypoint,datapartida,"
                    + "horapartida,telusuario)VALUES (?,?,?,?,?,?)");
            prepareStatement.setString(1, carona.getOrigem());
            prepareStatement.setString(2, carona.getDestino());
            prepareStatement.setString(3, carona.getWayPoint());
            prepareStatement.setString(4, carona.getDataPartida());
            prepareStatement.setString(5, carona.getHoraPartida());
            prepareStatement.setString(6, carona.getTelUsuario());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CaronaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean remover(Carona carona) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM carona WHERE id=?");
            prepareStatement.setInt(1, carona.getId());
            prepareStatement.execute();
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(Carona carona) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("UPDATE carona set origem=?, destino=?,waypoint=?,"
                    + "datapartida=?, horapartida=?, telusuario=? WHERE id=?");
            prepareStatement.setString(1, carona.getOrigem());
            prepareStatement.setString(2, carona.getDestino());
            prepareStatement.setString(3, carona.getWayPoint());
            prepareStatement.setString(4, carona.getDataPartida());
            prepareStatement.setString(5, carona.getHoraPartida());
            prepareStatement.setString(6, carona.getTelUsuario());
            prepareStatement.setInt(7, carona.getId());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CaronaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Carona> buscarTodos() {
        try {
            List<Carona> caronas = new ArrayList<>();

            ResultSet result = consultarTodasAsCaronas();

            while (result.next()) {
                caronas.add(criarCarona(result));
            }
            return caronas;

        } catch (SQLException ex) {
            Logger.getLogger(CaronaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Carona> buscarPorLocal(Carona carona) {
        try {
            List<Carona> caronas = new ArrayList<>();
            PreparedStatement prepareStatement = connection.prepareStatement("Select * from carona where "
                    + "origem=? or waypoint=? and destino=?");
            prepareStatement.setString(1, carona.getOrigem());
            prepareStatement.setString(2, carona.getOrigem());
            prepareStatement.setString(3, carona.getDestino());
            ResultSet result = prepareStatement.executeQuery();
            while (result.next()) {
                caronas.add(criarCarona(result));
            }
            return caronas;
        } catch (SQLException ex) {
            Logger.getLogger(CaronaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    private ResultSet consultarTodasAsCaronas() throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("Select * from carona");
        ResultSet result = prepareStatement.executeQuery();
        return result;
    }

    private Carona criarCarona(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String origem = result.getString("origem");
        String destino = result.getString("destino");
        String wayPoint = result.getString("waypoint");
        String dataPartida = result.getString("datapartida");
        String horaPartida = result.getString("horapartida");
        String telUsuario = result.getString("telusuario");
        return new Carona(id, origem, destino, wayPoint, dataPartida, horaPartida, telUsuario);
    }

    @Override
    public Carona buscaPorId(Carona carona) {
        Carona caronaRetorno = null;
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("Select * from carona where id=?");
            prepareStatement.setInt(1, carona.getId());
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                caronaRetorno = criarCarona(result);
            }
            return caronaRetorno;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return caronaRetorno;
    }
}
