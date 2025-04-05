package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection conectar() {
            Connection con = null;
            String url = "jdbc:mysql://127.0.0.1:3306/vital_care";
            String usuario = "root";
            String contraseña = "Herley";
            try {
                con = DriverManager.getConnection(url, usuario, contraseña);
                System.out.println("Conexion exitosa");
            } catch (SQLException e) {
                System.out.println("Error al conectar " + e.getMessage());
            }
        return con;
    }
}
