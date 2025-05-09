package Persistencias;
import java.util.StringJoiner;
public abstract class Metodos {
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

    public static String direccion(String a, String b, String c, String d, String e, String f, String g, String h) {
        StringJoiner direccionJ = new StringJoiner(" ");
        direccionJ.add(a);
        direccionJ.add(b);
        if (!c.isEmpty()) {
            direccionJ.add(c);
        }
        if (!d.isEmpty()) {
            direccionJ.add(d);
        }
        if (!e.isEmpty()) {
            direccionJ.add(e);
        }
        direccionJ.add("#");
        direccionJ.add(f);
        if (!g.isEmpty()) {
            direccionJ.add(g);
        }
        direccionJ.add("-");
        direccionJ.add(h);
        return direccionJ.toString();
    }
}
