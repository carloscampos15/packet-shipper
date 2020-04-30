/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Georeferenciacion;

import Modelos.Ciudad;
import Modelos.Departamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 *
 * @author Karen Dayanna Castaño Orjuela
 * @author Carlos Alberto Campos Armero
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

    public static ArrayList<Ciudad> obtenerCiudades(String nombreDepartamento) throws SQLException {
        nombreDepartamento = nombreDepartamento.trim();
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        String sql1 = "SELECT * FROM ciudades WHERE departamento = '" + nombreDepartamento + "'";
        ResultSet rs = statement.executeQuery(sql1);
        while (rs.next()) {
            ciudades.add(new Ciudad(rs.getString("ciudad"), rs.getString("departamento"), rs.getString("latitud"), rs.getString("longitud"), rs.getInt("codigo")));
        }
        return ciudades;
    }

    public static ArrayList<Departamento> obtenerDepartamentos() throws SQLException {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        String sql1 = "SELECT * FROM departamentos";
        ResultSet rs = statement.executeQuery(sql1);
        while (rs.next()) {
            departamentos.add(new Departamento(rs.getInt("id"), rs.getString("nombre")));
        }
        return departamentos;
    }

    public static Ciudad obtenerCiudad(String nombreCiudad, String nombreDepartamento) throws SQLException {
        nombreCiudad = nombreCiudad.trim();
        nombreDepartamento = nombreDepartamento.trim();
        String sql1 = "SELECT * FROM ciudades WHERE ciudad = '" + nombreCiudad + "' and departamento = '" + nombreDepartamento + "'";
        ResultSet rs = statement.executeQuery(sql1);
        while (rs.next()) {
            return new Ciudad(rs.getString("ciudad"), rs.getString("departamento"), rs.getString("latitud"), rs.getString("longitud"), rs.getInt("codigo"));
        }
        return null;
    }
}
