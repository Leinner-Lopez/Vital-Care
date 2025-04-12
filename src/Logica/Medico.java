package Logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Medico extends Usuario {

    private Conexion c = new Conexion();
    String especialidad;

    public Medico(String nombre1, String nombre2, String apellido1, String apellido2, String tipoDocumento, int numeroDocumento, Date fechaNacimiento, String correo, String telefono, String direccion, String barrio, String usuario, String contraseña, String especialidad) {
        super(nombre1, nombre2, apellido1, apellido2, tipoDocumento, numeroDocumento, fechaNacimiento, correo, telefono, direccion, barrio, usuario, contraseña);
        this.especialidad = especialidad;
    }

    public Medico() {
    }

    public void esteblecerDisponibilidad(Date fechaInicial, Date fechaFinal) {
        Usuario u = new Paciente();
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
            stmt.setString(3, u.getUsuario());
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

    @Override
    public void registrar() {
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

    @Override
    public Object[][] verCitas(String UsuariO) {
        List<Object[]> citas = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        ResultSet rta = null;
        ResultSet rta2 = null;
        ResultSet rta3 = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            con = c.conectar();
            String query1 = "SELECT num_documento FROM medicos WHERE usuario = ?";
            stmt = con.prepareStatement(query1);
            stmt.setString(1, UsuariO);
            rta = stmt.executeQuery();
            int numeroDOCUMENTO;
            if (rta.next()) {
                numeroDOCUMENTO = rta.getInt("num_documento");
            } else {
                return new Object[0][0];
            }
            String query2 = "SELECT documento_paciente, fecha_hora FROM citas WHERE documento_medico = ?";
            stmt2 = con.prepareStatement(query2);
            stmt2.setInt(1, numeroDOCUMENTO);
            rta2 = stmt2.executeQuery();
            while (rta2.next()) {
                Object[] datos = new Object[4];
                int DocumentoPaciente = rta2.getInt("documento_paciente");
                datos[0] = numeroDOCUMENTO;
                datos[3] = formato.format(rta2.getTimestamp("fecha_hora"));
                String query3 = "SELECT nombre_1, apellido_1, seguro_medico FROM pacientes WHERE num_documento = ?";
                stmt3 = con.prepareStatement(query3);
                stmt3.setInt(1, DocumentoPaciente);
                rta3 = stmt3.executeQuery();
                if (rta3.next()) {
                    datos[1] = rta3.getString("nombre_1") + " " + rta3.getString("apellido_1");
                    datos[2] = rta3.getString("seguro_medico");
                }
                citas.add(datos);
            }
            return citas.toArray(new Object[citas.size()][4]);
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
                if (rta != null) {
                    rta.close();
                }
                if (rta2 != null) {
                    rta2.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return new Object[0][0];
    }
}
