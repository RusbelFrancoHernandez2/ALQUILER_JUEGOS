/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.PersonaDTO;
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
public class PersonaDAO {

    Conexion conexion = new Conexion();

    public void insert(PersonaDTO personas) throws ClassNotFoundException {

        try {
            Connection connection = conexion.conn();

            Map<String, ?> sql = cargarQuerys();
            PreparedStatement pstmt = connection.prepareStatement(sql.get("Insert1").toString());
            pstmt.setString(1, personas.getNombre());
            pstmt.setString(2, personas.getTipo_documento());
            pstmt.setString(3, personas.getNumero_documento());
            pstmt.setTimestamp(4, new Timestamp(personas.getFecha_registro().getTime()));
            pstmt.setString(5, personas.getDireccion());
            pstmt.setLong(6, personas.getCelular());
            pstmt.executeUpdate();
            // Cerramos las conexiones, en orden inverso a su apertura
            pstmt.close();
            connection.close();

            System.out.println("base de datos actualizada");
        } catch (SQLException e) {
            System.out.println("the exceptio update is=" + e);
        }
    }

    public List<Map<String, ?>> forList(String numeroDocumento) throws ClassNotFoundException {

        List<Map<String, ?>> lista;
        Map<String, ?> sql = cargarQuerys();
        try {
            Connection connection = conexion.conn();
            PreparedStatement pstmt = connection.prepareStatement(sql.get("Select1").toString());
            pstmt.setString(1, numeroDocumento);
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

    private Map<String, ?> cargarQuerys() {
        Map<String, Object> row = new HashMap<>();
        row.put("Insert1", "INSERT INTO alquiler_juegos.personas (NOMBRE,TIPO_DOCUMENTO,NUMERO_DOCUMENTO,FECHA_REGISTRO,DIRECCION,CELULAR) VALUES (?,?,?,?,?,?)");
        row.put("Select1", "SELECT * FROM alquiler_juegos.personas WHERE NUMERO_DOCUMENTO = ?");
        return row;
    }

}
