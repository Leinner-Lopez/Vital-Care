package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String url = "jdbc:mysql://127.0.0.1:3306/vital_care";
    private final String usuario = "root";
    private final String contraseña = "Herley";
    Connection con = null;

    public Connection conectar() {
        try {
            con = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar " + e.getMessage());
        }
        return con;
    }
}
