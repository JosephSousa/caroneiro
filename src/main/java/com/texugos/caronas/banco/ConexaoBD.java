

package com.texugos.caronas.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @Since 11/07/2017 , 22:32:38
 */
public class ConexaoBD {
    private Connection conn;

    public void criarConexao() {
        try {
            String url = "jdbc:postgresql://localhost:5433/projetobdnc";
            String user = "postgres";
            String password = "123";
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException |ClassNotFoundException  e) {
            System.err.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        criarConexao();
        return this.conn;
    }

    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException ex) {
        }
}
}