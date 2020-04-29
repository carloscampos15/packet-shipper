/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Georeferenciacion;

import Modelos.Ciudad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class UbicacionBD {
    private static Connection connection;
    private static Statement statement;

    /**
     * Es la coneccion a la base de datos
     *
     * @return
     */
    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.err.println("ClassNotFoundException | InstantiationException | IllegalAccessException " + ex.getMessage());
            System.exit(1);
        }

        try {
            String url = "jdbc:sqlite:C:/sqlite3/db/distribuidos6.db";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();

            statement.setQueryTimeout(30); // segundos
            return connection;
        } catch (SQLException e) {
            System.err.println("[Servidor] (SQLException) " + e.getMessage());
            return connection;
        }
    }
    
    public static Ciudad obtenerCiudad(String nombreCiudad, String nombreDepartamento) throws SQLException {
        nombreCiudad = nombreCiudad.trim().toLowerCase();
        String sql1 = "SELECT * FROM ciudades WHERE ciudad = '" + nombreCiudad + "' and departamento = '"+ nombreDepartamento +"'";
        ResultSet rs = statement.executeQuery(sql1);
        while (rs.next()) {
            return new Ciudad(rs.getString("ciudad"), rs.getString("departamento"), rs.getString("latitud"), rs.getString("longitud"), rs.getInt("codigo"));
        }
        return null;
    }
    
    public static ArrayList<Ciudad> obtenerCiudades() throws SQLException {
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        String sql1 = "SELECT * FROM ciudades";
        ResultSet rs = statement.executeQuery(sql1);
        while (rs.next()) {
            ciudades.add(new Ciudad(rs.getString("ciudad"), rs.getString("departamento"), rs.getString("latitud"), rs.getString("longitud"), rs.getInt("codigo")));
        }
        System.out.println(ciudades.size());
        return ciudades;
    }
}
