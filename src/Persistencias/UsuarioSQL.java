package Persistencias;

import Modelos.Administrador;
import Modelos.Medico;
import Modelos.Paciente;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UsuarioSQL {

    Conexion c = new Conexion();

    public abstract void actualizarDatos();

    public abstract void registrar();

    public abstract Object[][] verCitas(String Usuario);

    public String verificarDatos(String Usuario, String Contraseña) {
        String[] tablas = {"pacientes", "medicos", "administradores"};
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            for (String i : tablas) {
                String query = "SELECT usuario FROM " + i + " WHERE usuario = ? AND contrasena = ?";
                stmt = con.prepareStatement(query);
                stmt.setString(1, Usuario);
                stmt.setString(2, Contraseña);
                rta = stmt.executeQuery();
                if (rta.next()) {
                    return i;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rta != null) {
                    rta.close();
                }
                if (con != null) {
                    con.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return "";
    }

    public boolean buscarExitenciadeNumeroDocumento(int NumeroDocumento, String tabla) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            String query = "SELECT usuario FROM " + tabla + " WHERE num_documento = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, NumeroDocumento);
            rta = stmt.executeQuery();
            if (rta.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rta != null) {
                    rta.close();
                }
                if (con != null) {
                    con.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean buscarExitenciadeUsuario(String Usuario) {
        String[] tablas = {"pacientes", "medicos", "administradores"};
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            for (String tabla: tablas) {
                con = c.conectar();
                String query = "SELECT num_documento FROM "+tabla+" WHERE usuario = ?";
                stmt = con.prepareStatement(query);
                stmt.setString(1, Usuario);
                rta = stmt.executeQuery();
                if (rta.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rta != null) {
                    rta.close();
                }
                if (con != null) {
                    con.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return false;
    }

    public Usuario recuperarNombreyCorreo() {
        Usuario user = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String query;
        String tabla = null;
        String tablas[] = {"pacientes", "medicos", "administradores"};
        ResultSet rta = null;
        int numeroDocumento = 0;
        try {
            con = c.conectar();
            for (String i : tablas) {
                query = "SELECT num_documento FROM " + i + " WHERE usuario = ?";
                stmt = con.prepareStatement(query);
                stmt.setString(1, Usuario.getUsuario());
                rta = stmt.executeQuery();
                if (rta.next()) {
                    numeroDocumento = rta.getInt("num_documento");
                    tabla = i;
                }
            }
            switch (tabla) {
                case "pacientes":
                    user = new Paciente();
                    break;
                case "medicos":
                    user = new Medico();
                    break;
                case "administradores":
                    user = new Administrador();
                    break;
                default:
                    user = new Medico();
            }
            query = "SELECT nombre_1, apellido_1, correo_electronico FROM " + tabla + " WHERE num_documento = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, numeroDocumento);
            rta = stmt.executeQuery();
            if (rta.next()) {
                user.setNombre1(rta.getString("nombre_1"));
                user.setApellido1(rta.getString("apellido_1"));
                user.setCorreo(rta.getString("correo_electronico"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rta != null) {
                    rta.close();
                }
                if (con != null) {
                    con.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return user;
    }

}
