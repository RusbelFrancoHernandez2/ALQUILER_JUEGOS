/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.AlquilerDTO;
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
public class AlquilerDAO {
                Conexion conexion = new Conexion();

    public void insert(AlquilerDTO alquiler) {

        try {
            Connection connection = conexion.conn();

            Map<String, ?> sql = cargarQuerys();
            PreparedStatement pstmt = connection.prepareStatement(sql.get("Insert1").toString());
            pstmt.setInt(1, alquiler.getId_persona());
            pstmt.setInt(2, alquiler.getId_juego());
            pstmt.setTimestamp(3, new Timestamp(alquiler.getFecha_entrega().getTime()));
            pstmt.setTimestamp(4, new Timestamp(alquiler.getFecha_registro().getTime()));
            pstmt.setString(5, alquiler.getEntregado());
            pstmt.setLong(6, alquiler.getValor_venta());

            ResultSet rs = pstmt.executeQuery();
            // Cerramos las conexiones, en orden inverso a su apertura
            pstmt.close();
            connection.close();

            System.out.println("base de datos actualizada" + rs);
        } catch (SQLException e) {
            System.out.println("the exceptio update is=" + e);
        }
    }
        
    public List<Map<String, ?>> forList(String query) {

        List<Map<String, ?>> lista;

        try {
            Connection connection = conexion.conn();
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            lista = rsToList(resultSet);

            // Cerramos las conexiones, en orden inverso a su apertura
            st.close();
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
        row.put("Insert1","INSERT INTO ALQUILER (ID_ALQUILER, ID_PERSONA, ID_JUEGO, FECHA_ENTREGA, FECHA_REGISTRO, ENTREGADO, VALOR_VENTA) VALUES (S_PERSONAS_IDPERSONAS.NEXTVAL,?, ?, ?, ?, ?, ?)");
        
        return row;
    }
        
}
