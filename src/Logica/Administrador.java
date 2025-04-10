package Logica;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Administrador extends Usuario {

    private Conexion c = new Conexion();

    public Administrador() {
    }

    public Administrador(String nombre1, String nombre2, String apellido1, String apellido2, String tipoDocumento, int numeroDocumento, Date fechaNacimiento, String correo, String telefono, String direccion, String barrio, String usuario, String contraseña) {
        super(nombre1, nombre2, apellido1, apellido2, tipoDocumento, numeroDocumento, fechaNacimiento, correo, telefono, direccion, barrio, usuario, contraseña);
    }

    public void registrarAd() {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = c.conectar();
            String query = "INSERT INTO administradores (nombre_1, nombre_2, apellido_1, apellido_2, tipo_documento, num_documento, fecha_nacimiento, direccion, barrio, correo_electronico, num_telefono, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            stmt.setString(10, correo);
            stmt.setString(11, telefono);
            stmt.setString(12, usuario);
            stmt.setString(13, contraseña);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Datos registrados con exito", "Usuario Registrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Usuario no resgistrado");
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

    public Object[][] visualizarMedicos() {
        List<Object[]> medicos = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            String query = "SELECT nombre_1, apellido_1, tipo_documento, num_documento, especialidad, num_telefono FROM medicos";
            stmt = con.prepareStatement(query);
            rta = stmt.executeQuery();
            while (rta.next()) {
                Object[] fila = new Object[6];
                fila[0] = rta.getString("nombre_1");
                fila[1] = rta.getString("apellido_1");
                fila[2] = rta.getString("tipo_documento");
                fila[3] = rta.getInt("num_documento");
                fila[4] = rta.getString("especialidad");
                fila[5] = rta.getString("num_telefono");
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

    public Object[][] visualizarPacientes() {
        List<Object[]> pacientes = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            String query = "SELECT nombre_1, apellido_1, tipo_documento, num_documento, seguro_medico, num_telefono FROM pacientes";
            stmt = con.prepareStatement(query);
            rta = stmt.executeQuery();
            while (rta.next()) {
                Object[] fila = new Object[6];
                fila[0] = rta.getString("nombre_1");
                fila[1] = rta.getString("apellido_1");
                fila[2] = rta.getString("tipo_documento");
                fila[3] = rta.getInt("num_documento");
                fila[4] = rta.getString("seguro_medico");
                fila[5] = rta.getString("num_telefono");
                pacientes.add(fila);
            }
            return pacientes.toArray(new Object[pacientes.size()][6]);
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

    public void eliminarPaciente(int NUMERODocumento) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = c.conectar();
            String query = "DELETE FROM pacientes WHERE num_documento = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, NUMERODocumento);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Paciente eliminado con exito", "Paciente Eliminado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("No se pudo eliminar el usuario");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
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

    public void eliminarMedico(int NuMeRoDocumento) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = c.conectar();
            String query = "DELETE FROM medicos WHERE num_documento = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, NuMeRoDocumento);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Medico eliminado con exito", "Medico Eliminado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("No pudo eliminar el Medico");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: "+e.getMessage());
            }

        }
    }
}
