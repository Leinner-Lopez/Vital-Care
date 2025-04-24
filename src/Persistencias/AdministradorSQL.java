package Persistencias;

import Modelos.Administrador;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AdministradorSQL extends UsuarioSQL {
    private Conexion c = new Conexion();
    private Administrador admin;

    public AdministradorSQL(Administrador admin) {
        this.admin = admin;
    }
    
    public AdministradorSQL() {
    }

    @Override
    public void registrar() {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = c.conectar();
            String query = "INSERT INTO administradores (nombre_1, nombre_2, apellido_1, apellido_2, tipo_documento, num_documento, fecha_nacimiento, direccion, barrio, correo_electronico, num_telefono, usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, admin.getNombre1());
            stmt.setString(2, admin.getNombre2());
            stmt.setString(3, admin.getApellido1());
            stmt.setString(4, admin.getApellido2());
            stmt.setString(5, admin.getTipoDocumento());
            stmt.setInt(6, admin.getNumeroDocumento());
            java.sql.Date fechasql = new java.sql.Date(admin.getFechaNacimiento().getTime());
            stmt.setDate(7, fechasql);
            stmt.setString(8, admin.getDireccion());
            stmt.setString(9, admin.getBarrio());
            stmt.setString(10, admin.getCorreo());
            stmt.setString(11, admin.getTelefono());
            stmt.setString(12, Administrador.getUsuario());
            stmt.setString(13, admin.getContraseña());
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

    @Override
    public void actualizarDatos() {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = c.conectar();
            String query = "UPDATE administradores SET nombre_1 = ?, nombre_2 = ?, apellido_1 = ?, apellido_2 = ?, tipo_documento = ?, fecha_nacimiento = ?, direccion = ?, barrio = ?, correo_electronico = ?, num_telefono = ?, usuario = ?, contrasena = ? WHERE num_documento = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, admin.getNombre1());
            stmt.setString(2, admin.getNombre2());
            stmt.setString(3, admin.getApellido1());
            stmt.setString(4, admin.getApellido2());
            stmt.setString(5, admin.getTipoDocumento());
            java.sql.Date fechasql = new java.sql.Date(admin.getFechaNacimiento().getTime());
            stmt.setDate(6, fechasql);
            stmt.setString(7, admin.getDireccion());
            stmt.setString(8, admin.getBarrio());
            stmt.setString(9, admin.getCorreo());
            stmt.setString(10, admin.getTelefono());
            stmt.setString(11, Administrador.getUsuario());
            stmt.setString(12, admin.getContraseña());
            stmt.setInt(13, admin.getNumeroDocumento());
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Datos actualizados con exito", "Datos actualizados", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Datos Actualizados");
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
    public Object[][] verCitas(String Usuario) {
        List<Object[]> citas = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmtCitas = null;
        PreparedStatement stmtMedico = null;
        ResultSet rtaCitas = null;
        ResultSet rtaMedico = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            con = c.conectar();
            String queryCitas = "SELECT documento_paciente, documento_medico, fecha_hora FROM citas";
            stmtCitas = con.prepareStatement(queryCitas);
            rtaCitas = stmtCitas.executeQuery();

            while (rtaCitas.next()) {
                Object[] datos = new Object[4];

                int docPaciente = rtaCitas.getInt("documento_paciente");
                int docMedico = rtaCitas.getInt("documento_medico");
                Timestamp fechaHora = rtaCitas.getTimestamp("fecha_hora");

                datos[0] = docPaciente;
                datos[3] = formato.format(fechaHora);

                // Buscar datos del médico
                String queryMedico = "SELECT nombre_1, apellido_1, especialidad FROM medicos WHERE num_documento = ?";
                stmtMedico = con.prepareStatement(queryMedico);
                stmtMedico.setInt(1, docMedico);
                rtaMedico = stmtMedico.executeQuery();

                if (rtaMedico.next()) {
                    String nombreCompleto = rtaMedico.getString("nombre_1") + " " + rtaMedico.getString("apellido_1");
                    datos[1] = nombreCompleto;
                    datos[2] = rtaMedico.getString("especialidad");
                }

                citas.add(datos);
            }

            return citas.toArray(new Object[citas.size()][4]);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rtaCitas != null) {
                    rtaCitas.close();
                }
                if (stmtCitas != null) {
                    stmtCitas.close();
                }
                if (con != null) {
                    con.close();
                }
                if (rtaMedico != null) {
                    rtaMedico.close();
                }
                if (stmtMedico != null) {
                    stmtMedico.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return new Object[0][0];
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

    public Object[][] visualizarAdministradores() {
        List<Object[]> administradores = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            String query = "SELECT nombre_1, apellido_1, tipo_documento, num_documento, num_telefono FROM administradores";
            stmt = con.prepareStatement(query);
            rta = stmt.executeQuery();
            while (rta.next()) {
                Object[] fila = new Object[5];
                fila[0] = rta.getString("nombre_1");
                fila[1] = rta.getString("apellido_1");
                fila[2] = rta.getString("tipo_documento");
                fila[3] = rta.getInt("num_documento");
                fila[4] = rta.getString("num_telefono");
                administradores.add(fila);
            }
            return administradores.toArray(new Object[administradores.size()][6]);
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
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void eliminarAdministrador(int NuMeRoDocumento) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = c.conectar();
            String query = "DELETE FROM administradores WHERE num_documento = ?";
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
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public String[] editarPaciente(int NumeroDocumentO) {
        String[] paciente = new String[14];
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            String query = "SELECT * FROM pacientes WHERE num_documento=?";
            stmt = con.prepareCall(query);
            stmt.setInt(1, NumeroDocumentO);
            rta = stmt.executeQuery();
            if (rta.next()) {
                paciente[0] = rta.getString("nombre_1");
                paciente[1] = rta.getString("nombre_2");
                paciente[2] = rta.getString("apellido_1");
                paciente[3] = rta.getString("apellido_2");
                paciente[4] = rta.getString("tipo_documento");
                paciente[5] = rta.getString("num_documento");
                paciente[6] = rta.getString("fecha_nacimiento");
                paciente[7] = rta.getString("direccion");
                paciente[8] = rta.getString("barrio");
                paciente[9] = rta.getString("seguro_medico");
                paciente[10] = rta.getString("correo_electronico");
                paciente[11] = rta.getString("num_telefono");
                paciente[12] = rta.getString("usuario");
                paciente[13] = rta.getString("contrasena");
                return paciente;
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
                if (rta != null) {
                    rta.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return paciente;
    }

    public String[] editarMedico(int NumeroDocumentO) {
        String[] medico = new String[14];
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            String query = "SELECT * FROM medicos WHERE num_documento=?";
            stmt = con.prepareCall(query);
            stmt.setInt(1, NumeroDocumentO);
            rta = stmt.executeQuery();
            if (rta.next()) {
                medico[0] = rta.getString("nombre_1");
                medico[1] = rta.getString("nombre_2");
                medico[2] = rta.getString("apellido_1");
                medico[3] = rta.getString("apellido_2");
                medico[4] = rta.getString("tipo_documento");
                medico[5] = rta.getString("num_documento");
                medico[6] = rta.getString("fecha_nacimiento");
                medico[7] = rta.getString("direccion");
                medico[8] = rta.getString("barrio");
                medico[9] = rta.getString("especialidad");
                medico[10] = rta.getString("correo_electronico");
                medico[11] = rta.getString("num_telefono");
                medico[12] = rta.getString("usuario");
                medico[13] = rta.getString("contrasena");
                return medico;
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
                if (rta != null) {
                    rta.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return medico;
    }

    public String[] editarAdministrador(int NumeroDocumentO) {
        String[] administrador = new String[13];
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            String query = "SELECT * FROM administradores WHERE num_documento=?";
            stmt = con.prepareCall(query);
            stmt.setInt(1, NumeroDocumentO);
            rta = stmt.executeQuery();
            if (rta.next()) {
                administrador[0] = rta.getString("nombre_1");
                administrador[1] = rta.getString("nombre_2");
                administrador[2] = rta.getString("apellido_1");
                administrador[3] = rta.getString("apellido_2");
                administrador[4] = rta.getString("tipo_documento");
                administrador[5] = rta.getString("num_documento");
                administrador[6] = rta.getString("fecha_nacimiento");
                administrador[7] = rta.getString("direccion");
                administrador[8] = rta.getString("barrio");
                administrador[9] = rta.getString("correo_electronico");
                administrador[10] = rta.getString("num_telefono");
                administrador[11] = rta.getString("usuario");
                administrador[12] = rta.getString("contrasena");
                return administrador;
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
                if (rta != null) {
                    rta.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return administrador;
    }
}
