/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rfranco
 */
public class Conexion {

    public Conexion() {
    }

    public Connection conn() throws SQLException {

        Connection connection;
        String user = "alquiler";
        String password = "Op3r4t1v0s*";
        String url = "jdbc:mysql://localhost:3306/alquiler_juegos?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            System.out.println("conectando a base de datos ....");
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("the exception is=" + e);
            connection = null;
        }
        return connection;
    }
}
