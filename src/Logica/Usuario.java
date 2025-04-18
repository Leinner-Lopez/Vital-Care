package Logica;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;
import Conexion.Conexion;

public abstract class Usuario {

    protected String nombre1;
    protected String nombre2;
    protected String apellido1;
    protected String apellido2;
    protected String tipoDocumento;
    protected int numeroDocumento;
    protected Date fechaNacimiento;
    protected String correo;
    protected String telefono;
    protected String direccion;
    protected String barrio;
    protected static String usuario;
    protected String contraseña;
    private Conexion c = new Conexion();

    public Usuario() {
    }

    public Usuario(String nombre1, String nombre2, String apellido1, String apellido2, String tipoDocumento, int numeroDocumento, Date fechaNacimiento, String correo, String telefono, String direccion, String barrio, String usuario, String contraseña) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.barrio = barrio;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

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

    public boolean buscarExitenciadeUsuario(int NumeroDocumento) {
        String[] tablas = {"pacientes", "medicos", "administradores"};
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            for (String i : tablas) {
                String query = "SELECT usuario FROM " + i + " WHERE num_documento = ?";
                stmt = con.prepareStatement(query);
                stmt.setInt(1, NumeroDocumento);
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

    public void recuperarNombreyCorreo() {
        Connection con = null;
        PreparedStatement stmt = null;
        String query;
        String tablas[] = {"pacientes", "medicos", "administradores"};
        ResultSet rta = null;
        try {
            con = c.conectar();
            for (String i : tablas) {
                query = "SELECT num_documento FROM " + i + " WHERE usuario = ?";
                stmt = con.prepareStatement(query);
                stmt.setString(1, usuario);
                rta = stmt.executeQuery();
                if (rta.next()) {
                    numeroDocumento = rta.getInt("num_documento");
                }
            }
            for (String i : tablas) {
                query = "SELECT nombre_1, apellido_1, correo_electronico FROM " + i + " WHERE num_documento = ?";
                stmt = con.prepareStatement(query);
                stmt.setInt(1, numeroDocumento);
                rta = stmt.executeQuery();
                if (rta.next()) {
                    nombre1 = rta.getString("nombre_1");
                    apellido1 = rta.getString("apellido_1");
                    correo = rta.getString("correo_electronico");
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
    }

    public static String[] descomponerDireccion(String direccion) {
        // Resultado: [tipoVia, numeroPrincipal, bis, letraPrincipal, orientacion, numeroSecundario, letraSecundaria, numeroFinal]
        String[] partes = new String[8];

        // Limpiar espacios dobles por si acaso
        direccion = direccion.trim().replaceAll("\\s+", " ");

        try {
            // Separar por espacios y símbolos especiales
            String[] tokens = direccion.split(" ");

            // Tipo de vía (Calle/Carrera/Transversal/etc.)
            partes[0] = tokens[0]; // Calle, Carrera, etc.

            // Número principal con posible letra (4B)
            String numPrincipal = tokens[1];
            partes[1] = numPrincipal.replaceAll("[^\\d]", ""); // 4
            partes[3] = numPrincipal.replaceAll("\\d", "");    // B (si hay)

            // Bis (opcional)
            if (tokens[2].equalsIgnoreCase("Bis")) {
                partes[2] = "Bis";
            } else {
                partes[2] = ""; // No hay Bis
            }

            // Orientación (opcional)
            if (tokens[2].matches("(?i)(Norte|Sur|Este|Oeste)")) {
                partes[4] = tokens[2]; // Orientación
            } else {
                partes[4] = "";
            }

            // Separar parte con #
            String[] despuesDelNumeral = direccion.split("#")[1].split("-");

            String secundaria = despuesDelNumeral[0]; // Ej: 5B
            partes[5] = secundaria.replaceAll("[^\\d]", ""); // 5
            partes[6] = secundaria.replaceAll("\\d", "");    // B (si hay)

            partes[7] = despuesDelNumeral.length > 1 ? despuesDelNumeral[1] : ""; // 6

        } catch (Exception e) {
            System.out.println("Error al descomponer dirección: " + e.getMessage());
        }

        return partes;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getCorreo() {
        return correo;
    }

    public void setUsuario(String usuario) {
        Usuario.usuario = usuario;
    }

    public static String getUsuario() {
        return usuario;
    }
}
