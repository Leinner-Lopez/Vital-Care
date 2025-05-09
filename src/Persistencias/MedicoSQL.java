package Persistencias;

import Modelos.Usuario;
import Modelos.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class MedicoSQL extends UsuarioSQL {

    Medico medico;
    Conexion c = new Conexion();

    public MedicoSQL(Medico medico) {
        this.medico = medico;
    }

    public MedicoSQL() {
    }

    @Override
    public void actualizarDatos() {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = c.conectar();
            String query = "UPDATE medicos SET nombre_1 = ?, nombre_2 = ?, apellido_1 = ?, apellido_2 = ?, tipo_documento = ?,fecha_nacimiento= ?, direccion= ?, barrio= ?, "
                    + "especialidad= ?, correo_electronico= ?, num_telefono= ?, usuario= ?, contrasena= ? WHERE num_documento = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, medico.getNombre1());
            stmt.setString(2, medico.getNombre2());
            stmt.setString(3, medico.getApellido1());
            stmt.setString(4, medico.getApellido2());
            stmt.setString(5, medico.getTipoDocumento());
            java.sql.Date fechasql = new java.sql.Date(medico.getFechaNacimiento().getTime());
            stmt.setDate(6, fechasql);
            stmt.setString(7, medico.getDireccion());
            stmt.setString(8, medico.getBarrio());
            stmt.setString(9, medico.getEspecialidad());
            stmt.setString(10, medico.getCorreo());
            stmt.setString(11, medico.getTelefono());
            stmt.setString(12, Medico.getUsuario());
            stmt.setString(13, medico.getContraseña());
            stmt.setInt(14, medico.getNumeroDocumento());
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Datos actualizados con exito", "Datos Actualizados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Datos no actualizados");
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
            String query = "INSERT INTO medicos (nombre_1, nombre_2, apellido_1, apellido_2, tipo_documento, num_documento, fecha_nacimiento, direccion, barrio, especialidad, correo_electronico, "
                    + "num_telefono, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, medico.getNombre1());
            stmt.setString(2, medico.getNombre2());
            stmt.setString(3, medico.getApellido1());
            stmt.setString(4, medico.getApellido2());
            stmt.setString(5, medico.getTipoDocumento());
            stmt.setInt(6, medico.getNumeroDocumento());
            java.sql.Date fechasql = new java.sql.Date(medico.getFechaNacimiento().getTime());
            stmt.setDate(7, fechasql);
            stmt.setString(8, medico.getDireccion());
            stmt.setString(9, medico.getBarrio());
            stmt.setString(10, medico.getEspecialidad());
            stmt.setString(11, medico.getCorreo());
            stmt.setString(12, medico.getTelefono());
            stmt.setString(13, Medico.getUsuario());
            stmt.setString(14, medico.getContraseña());
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
    public Object[][] vizualizarCitas(String Usuario) {
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
            stmt.setString(1, Medico.getUsuario());
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
            stmt.setString(3, Usuario.getUsuario());
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
}
