/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.sql.*;

/**
 *
 * Clase que permite establecer una conexion con la base de datos.
 *
 * @author Cortez, Manuel;
 */
public class ConexionDB {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * Metodo que se ejuecuta en la instanciacion de la clase ConexionDB,
     * inicializa todos los parametros para la conexion.
     */
    static {
        try(InputStream input = ConexionDB.class.getClassLoader().getResourceAsStream("db.properties")){
            Properties props = new Properties();
            if (input == null){
                throw new RuntimeException("No se logo obtener el archivo de prpiedades");
            }
            props.load(input);
            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");
            driver = props.getProperty("db.driver");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException ex){
            throw new RuntimeException(ex.getMessage());
        }
     }

    /**
     *
     * Metodo que permite establecer la conexion con la base de datos.
     *
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}