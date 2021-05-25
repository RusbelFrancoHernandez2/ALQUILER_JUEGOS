/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.JuegosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rfranco
 */
public class JuegosDAO {
            Conexion conexion = new Conexion();

    public void insert(JuegosDTO juegos) {

        try {
            Connection connection = conexion.conn();

            Map<String, ?> sql = cargarQuerys();
            PreparedStatement pstmt = connection.prepareStatement(sql.get("Insert1").toString());
            pstmt.setString(1, juegos.getTitulo());
            pstmt.setString(2, juegos.getGenero());
            pstmt.setTimestamp(3, new Timestamp(juegos.getYear().getTime()));
            pstmt.setString(4, juegos.getProtagonistas());
            pstmt.setString(5, juegos.getProductor());
            pstmt.setString(6, juegos.getDirector());
            pstmt.setString(7, juegos.getTecnologia());
            pstmt.setLong(8, juegos.getPrecio_alquiler());
            ResultSet rs = pstmt.executeQuery();
            // Cerramos las conexiones, en orden inverso a su apertura
            pstmt.close();
            connection.close();

            System.out.println("base de datos actualizada" + rs);
        } catch (SQLException e) {
            System.out.println("the exceptio update is=" + e);
        }
    }

        public void update(JuegosDTO juegos) {

        try {
            Connection connection = conexion.conn();

            Map<String, ?> sql = cargarQuerys();
            PreparedStatement pstmt = connection.prepareStatement(sql.get("Update1").toString());
            pstmt.setString(1, juegos.getTitulo());
            pstmt.setString(2, juegos.getGenero());
            pstmt.setTimestamp(3, new Timestamp(juegos.getYear().getTime()));
            pstmt.setString(4, juegos.getProtagonistas());
            pstmt.setString(5, juegos.getProductor());
            pstmt.setString(6, juegos.getDirector());
            pstmt.setString(7, juegos.getTecnologia());
            pstmt.setLong(8, juegos.getPrecio_alquiler());
            pstmt.setInt(9, juegos.getId_juego());
            
            ResultSet rs = pstmt.executeQuery();
            // Cerramos las conexiones, en orden inverso a su apertura
            pstmt.close();
            connection.close();

            System.out.println("base de datos actualizada" + rs);
        } catch (SQLException e) {
            System.out.println("the exceptio update is=" + e);
        }
    }
        
    public List<Map<String, ?>> forList(JuegosDTO juegos) {

        List<Map<String, ?>> lista;

        try {
            Connection connection = conexion.conn();
            Map<String, ?> sql = cargarQuerys();
            PreparedStatement pstmt = connection.prepareStatement(sql.get("Select1").toString());
            pstmt.setInt(9, juegos.getId_juego());
            ResultSet resultSet = pstmt.executeQuery();
            lista = rsToList(resultSet);

            // Cerramos las conexiones, en orden inverso a su apertura
            pstmt.close();
            connection.close();

            System.out.println("datos consultados con éxito a la base de datos.");
        } catch (SQLException e) {
            System.out.println("the exceptio forList is=" + e);
            lista = null;
        }
        return lista;
    }
    
    public List<Map<String, ?>> rsToList(ResultSet rs)
            throws SQLException {
        ResultSetMetaData md = rs.getMetaData();

        int columns = md.getColumnCount();
        List<Map<String, ?>> results = new ArrayList<>();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= columns; i++) {
                row.put(md.getColumnLabel(i).toUpperCase(), rs.getObject(i));

            }
            results.add(row);
        }

        return results;
    }
    
    private Map<String, ?> cargarQuerys (){
        Map<String, Object> row = new HashMap<>();
        row.put("Insert1","INSERT INTO JUEGOS (ID_JUEGO, TITULO, GENERO, YEAR, PROTAGONISTAS, DIRECTOR, PRODUCTOR, TECNOLOGIA, PRECIO_ALQUILER) VALUES (S_JUEGOS_IDJUEGO.NEXTVAL,?,?,?,?,?,?,?,?)");
        row.put("Select1","SELECT * FORM JUEGOS WHERE ID_JUEGO = ?");
        return row;
    }
        
}
