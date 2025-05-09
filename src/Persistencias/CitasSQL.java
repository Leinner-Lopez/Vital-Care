package Persistencias;

import Modelos.Medico;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class CitasSQL {

    Conexion c = new Conexion();

    public Medico determinarNumeroDocumentoMedico(String nombre_1, String apellido_1, String especialidad) {
        Medico medico = new Medico();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        try {
            con = c.conectar();
            String query = "SELECT num_documento FROM medicos WHERE nombre_1=? AND apellido_1 = ? AND especialidad = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, nombre_1);
            stmt.setString(2, apellido_1);
            stmt.setString(3, especialidad);
            rta = stmt.executeQuery();
            if (rta.next()) {
                medico.setNumeroDocumento(rta.getInt("num_documento"));            }
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

    public ArrayList<String> obtenerCitasTomadas(Timestamp inicioDisponibilidad, Timestamp finDisponibilidad, Medico medico) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rta = null;
        ArrayList<String> horasDisponibles = new ArrayList<>();
        try {
            con = c.conectar();
            String query = "SELECT fecha_hora FROM citas WHERE documento_medico = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, medico.getNumeroDocumento());
            rta = stmt.executeQuery();
            ArrayList<LocalDateTime> citasTomadas = new ArrayList<>();
            while (rta.next()) {
                Timestamp fechaHora = rta.getTimestamp("fecha_hora");
                citasTomadas.add(fechaHora.toLocalDateTime());
            }
            LocalDateTime inicio = inicioDisponibilidad.toLocalDateTime();
            LocalDateTime fin = finDisponibilidad.toLocalDateTime();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while (!inicio.isAfter(fin)) {
                boolean ocupada = false;
                for (LocalDateTime cita : citasTomadas) {
                    if (cita.isEqual(inicio)) {
                        ocupada = true;
                        break;
                    }
                }
                if (!ocupada) {
                    horasDisponibles.add(inicio.format(formato));
                }
                inicio = inicio.plusMinutes(15);
            }
            return horasDisponibles;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rta != null) {
                    rta.close();
                }
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
        return horasDisponibles;
    }

    public void agendarCita(int NumeroDocumento, Date HoraCita) {
        Timestamp fechasql = new Timestamp(HoraCita.getTime());
        Connection con = null;
        ResultSet rta = null;
        PreparedStatement stmt = null;
        try {
            con = c.conectar();
            String query = "SELECT num_documento FROM pacientes WHERE usuario = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, Usuario.getUsuario());
            rta = stmt.executeQuery();
            int numeroDocumento = 0;
            if (rta.next()) {
                numeroDocumento = rta.getInt("num_documento");
            }
            query = "INSERT INTO citas (fecha_hora, documento_paciente, documento_medico) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(query);
            stmt.setTimestamp(1, fechasql);
            stmt.setInt(2, numeroDocumento);
            stmt.setInt(3, NumeroDocumento);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Cita Agendada con exito", "Cita agendada", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rta != null) {
                    rta.close();
                }
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
