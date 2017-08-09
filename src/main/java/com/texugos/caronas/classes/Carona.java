

package com.texugos.caronas.classes;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 22/07/2017 , 13:23:46
 */
public class Carona {
    
    private int id;
    private String origem;
    private String destino;
    private String wayPoint;
    private String dataPartida;
    private String horaPartida;
    private String telUsuario;

    public Carona() {
    }
    
    public Carona(int id, String origem, String destino, String wayPoint, String dataPartida, String horaPartida, String telUsuario) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.wayPoint = wayPoint;
        this.dataPartida = dataPartida;
        this.horaPartida = horaPartida;
        this.telUsuario = telUsuario;
    }

    public String getTelUsuario() {
        return telUsuario;
    }

    public void setTelUsuario(String telUsuario) {
        this.telUsuario = telUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getWayPoint() {
        return wayPoint;
    }

    public void setWayPoint(String wayPoint) {
        this.wayPoint = wayPoint;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    @Override
    public String toString() {
        return "Carona{" + "id=" + id + ", origem=" + origem + ", destino=" + destino + ", wayPoint=" + wayPoint + ", dataPartida=" + dataPartida + ", horaPartida=" + horaPartida + ", telUsuario=" + telUsuario + '}';
    }
    
}
