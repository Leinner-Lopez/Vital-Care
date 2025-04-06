package Logica;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;
import Conexion.Conexion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Paciente extends Usuario {

    private String seguroMedico;
    private Conexion c = new Conexion();

    public Paciente() {
    }

    public Paciente(String nombre1, String nombre2, String apellido1, String apellido2, String tipoDocumento, int numeroDocumento, Date fechaNacimiento, String correo, String telefono, String direccion, String barrio, String seguroMedico, String usuario, String contraseña) {
        super(nombre1, nombre2, apellido1, apellido2, tipoDocumento, numeroDocumento, fechaNacimiento, correo, telefono, direccion, barrio, usuario, contraseña);
        this.seguroMedico = seguroMedico;
    }

    //Registramos a el Usuario en la base de datos 
    public void registrarPa() {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = c.conectar();
            String query = "INSERT INTO pacientes (nombre_1, nombre_2, apellido_1, apellido_2, tipo_documento, num_documento, fecha_nacimiento, direccion, barrio, seguro_medico, correo_electronico, num_telefono, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            stmt.setString(10, seguroMedico);
            stmt.setString(11, correo);
            stmt.setString(12, telefono);
            stmt.setString(13, usuario);
            stmt.setString(14, contraseña);
            int filasinsertadas = stmt.executeUpdate();
            if (filasinsertadas > 0) {
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

    public Object[][] verCitas(String UsUaRio) {
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
            String query1 = "SELECT num_documento FROM pacientes WHERE usuario = ?";
            stmt = con.prepareStatement(query1);
            stmt.setString(1, UsUaRio);
            rta = stmt.executeQuery();
            int numeroDOCUMENTO = -1;
            if (rta.next()) {
                numeroDOCUMENTO = rta.getInt("num_documento");
            }else{
                return new Object[0][0];
            }
            String query2 = "SELECT documento_medico, fecha_hora FROM citas WHERE documento_paciente = ?";
            stmt2 = con.prepareStatement(query2);
            stmt2.setInt(1, numeroDOCUMENTO);
            rta2 = stmt2.executeQuery();
            while (rta2.next()) {
                Object[] datos = new Object[4];
                int DocumentoMedico = rta2.getInt("documento_medico");
                datos[0] = numeroDOCUMENTO;
                datos[3] = formato.format(rta2.getTimestamp("fecha_hora"));
                String query3 = "SELECT nombre_1, apellido_1, especialidad FROM medicos WHERE num_documento = ?";
                stmt3 = con.prepareStatement(query3);
                stmt3.setInt(1, DocumentoMedico);
                rta3 = stmt3.executeQuery();
                if (rta3.next()) {
                    datos[1] = rta3.getString("nombre_1") + " "+rta3.getString("apellido_1");
                    datos[2] = rta3.getString("especialidad");
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

    public Object[][] verMedicos() {
        List<Object[]> medicos = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            String query = "SELECT nombre_1, apellido_1, especialidad, disp_ini, disp_fin FROM medicos";
            stmt = con.prepareStatement(query);
            rta = stmt.executeQuery();
            while (rta.next()) {
                Object[] fila = new Object[5];
                fila[0] = rta.getString("nombre_1");
                fila[1] = rta.getString("apellido_1");
                fila[2] = rta.getString("especialidad");
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                fila[3] = formato.format(rta.getTimestamp("disp_ini"));
                fila[4] = formato.format(rta.getTimestamp("disp_fin"));
                medicos.add(fila);
            }
            return medicos.toArray(new Object[medicos.size()][5]);
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
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
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return new Object[0][0];
    }

    public Object[][] buscarMedicos(String Especialidad) {
        List<Object[]> medicos = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            String query = "SELECT nombre_1, apellido_1, especialidad, disp_ini, disp_fin FROM medicos WHERE especialidad = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, Especialidad);
            rta = stmt.executeQuery();
            while (rta.next()) {
                Object[] fila = new Object[5];
                fila[0] = rta.getString("nombre_1");
                fila[1] = rta.getString("apellido_1");
                fila[2] = rta.getString("especialidad");
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                fila[3] = formato.format(rta.getTimestamp("disp_ini"));
                fila[4] = formato.format(rta.getTimestamp("disp_fin"));
                medicos.add(fila);
            }
            return medicos.toArray(new Object[medicos.size()][5]);
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
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
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return new Object[0][0];
    }
}
