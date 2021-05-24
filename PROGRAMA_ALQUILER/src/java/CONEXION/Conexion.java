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
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("conectando a base de datos ....");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ALQUILER_JUEGOS", "123");

        } catch (Exception e) {
            System.out.println("the exceptio is=" + e);
            connection = null;
        }
        return connection;
    }
}
