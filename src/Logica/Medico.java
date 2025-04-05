package Logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Medico extends Usuario {

    private Conexion c = new Conexion();
    String especialidad;

    public Medico() {
    }
    

    public void esteblecerDisponibilidad(Date fechaInicial, Date fechaFinal) {
        Connection con = null;
        PreparedStatement stmt = null;
        java.sql.Timestamp fechaInicio = new java.sql.Timestamp(fechaInicial.getTime());
        java.sql.Timestamp fechaFin = new java.sql.Timestamp(fechaFinal.getTime());
        try {
            con = c.conectar();
            String query = "UPDATE medicos SET disp_ini = ?, disp_fin = ? WHERE usuario = ?";
            stmt = con.prepareStatement(query);
            stmt.setTimestamp(1, fechaInicio);
            stmt.setTimestamp(2, fechaFin);
            stmt.setString(3, Usuario.usuario);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Disponibilidad registrada con exito", "Disponibilidad Registrada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Disponibilidad no registrada");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerrar recursos en el bloque finally
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public Medico(String nombre1, String nombre2, String apellido1, String apellido2, String tipoDocumento, int numeroDocumento, Date fechaNacimiento, String correo, String telefono, String direccion, String barrio, String usuario, String contraseña, String especialidad) {
        super(nombre1, nombre2, apellido1, apellido2, tipoDocumento, numeroDocumento, fechaNacimiento, correo, telefono, direccion, barrio, usuario, contraseña);
        this.especialidad = especialidad;
    }

    public void registrarMe() {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = c.conectar();
            String query = "INSERT INTO medicos (nombre_1, nombre_2, apellido_1, apellido_2, tipo_documento, num_documento, fecha_nacimiento, direccion, barrio, especialidad, correo_electronico, num_telefono, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, nombre1);
            stmt.setString(2, nombre2);
            stmt.setString(3, apellido1);
            stmt.setString(4, apellido2);
            stmt.setString(5, tipoDocumento);
            stmt.setInt(6, numeroDocumento);
            java.sql.Date fechasql = new java.sql.Date(fechaNacimiento.getTime());
            stmt.setDate(7, fechasql);
            stmt.setString(8, direccion);
            stmt.setString(9, barrio);
            stmt.setString(10, especialidad);
            stmt.setString(11, correo);
            stmt.setString(12, telefono);
            stmt.setString(13, usuario);
            stmt.setString(14, contraseña);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Datos registrados con exito", "Usuario Registrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Usuario no registrado");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerrar recursos en el bloque finally
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
