package Interfaz.Administrador;

import Interfaz.IniciarSesion;
import Logica.Medico;
import Logica.Paciente;
import Logica.Usuario;
import java.util.Date;
import java.util.StringJoiner;
import javax.swing.JOptionPane;

public class CrearCuentaMedico extends javax.swing.JFrame {

    Usuario U = new Paciente();
    boolean estado = false;

    public CrearCuentaMedico() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        this.setTitle("Crear Cuenta");
        BTNmostrar.setText("Mostrar");
        JPConfirmarContraseña.setEchoChar('•');
        JPContraseña.setEchoChar('•');

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLDatos_Usuario = new javax.swing.JLabel();
        JLnombre_1 = new javax.swing.JLabel();
        JTnombre_1 = new javax.swing.JTextField();
        JLnombre_2 = new javax.swing.JLabel();
        JTnombre_2 = new javax.swing.JTextField();
        JLapellido_1 = new javax.swing.JLabel();
        JTapellido_1 = new javax.swing.JTextField();
        JLapellido_2 = new javax.swing.JLabel();
        JTapellido_2 = new javax.swing.JTextField();
        JLTipo_Documento = new javax.swing.JLabel();
        CBTipo_Documento = new javax.swing.JComboBox<>();
        JLNumero_Documento = new javax.swing.JLabel();
        JTNumero_Documento = new javax.swing.JTextField();
        JLFecha_Nacimiento = new javax.swing.JLabel();
        JSFecha_Nacimiento = new javax.swing.JSpinner();
        JLDatosContacto = new javax.swing.JLabel();
        JLNumero_Telefono = new javax.swing.JLabel();
        JTCorreo_Electronico = new javax.swing.JTextField();
        JLCorreoElectronico = new javax.swing.JLabel();
        JTTelefono = new javax.swing.JTextField();
        JLNumeral = new javax.swing.JLabel();
        CBLetras2 = new javax.swing.JComboBox<>();
        JCBIS = new javax.swing.JCheckBox();
        JTNumero2 = new javax.swing.JTextField();
        CBTipo_Via1 = new javax.swing.JComboBox<>();
        JLBarrio = new javax.swing.JLabel();
        JTNumero_Principal1 = new javax.swing.JTextField();
        JLRaya = new javax.swing.JLabel();
        JTNumero1 = new javax.swing.JTextField();
        CBBarrio = new javax.swing.JComboBox<>();
        JLDireccion1 = new javax.swing.JLabel();
        CBOrientacion1 = new javax.swing.JComboBox<>();
        BTNResgistrarse = new javax.swing.JButton();
        CBLetras1 = new javax.swing.JComboBox<>();
        JLSeguroMedico = new javax.swing.JLabel();
        CBEspecialidad = new javax.swing.JComboBox<>();
        JLDatosCuenta = new javax.swing.JLabel();
        JLUsuario = new javax.swing.JLabel();
        JTUsuario = new javax.swing.JTextField();
        BTNmostrar = new javax.swing.JButton();
        JPConfirmarContraseña = new javax.swing.JPasswordField();
        JPContraseña = new javax.swing.JPasswordField();
        JLContraseña = new javax.swing.JLabel();
        JLConfirmarContraseña = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JLDatos_Usuario.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        JLDatos_Usuario.setText("Datos del Usuario");

        JLnombre_1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLnombre_1.setText("Primer Nombre");

        JTnombre_1.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N

        JLnombre_2.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLnombre_2.setText("Segundo Nombre");

        JTnombre_2.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N

        JLapellido_1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLapellido_1.setText("Primer Apellido");

        JTapellido_1.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N

        JLapellido_2.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLapellido_2.setText("Segundo Apellido");

        JTapellido_2.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N

        JLTipo_Documento.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLTipo_Documento.setText("Tipo de Documento");

        CBTipo_Documento.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CBTipo_Documento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CC", "CE", "PAS", "PEP", "PPN" }));

        JLNumero_Documento.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLNumero_Documento.setText("Numero de Documento");

        JTNumero_Documento.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N

        JLFecha_Nacimiento.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLFecha_Nacimiento.setText("Fecha de Nacimiento");

        JSFecha_Nacimiento.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JSFecha_Nacimiento.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_YEAR));
        JSFecha_Nacimiento.setEditor(new javax.swing.JSpinner.DateEditor(JSFecha_Nacimiento, "yyyy-MM-dd"));

        JLDatosContacto.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        JLDatosContacto.setText("Datos de Contacto");

        JLNumero_Telefono.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLNumero_Telefono.setText("Numero de Telefono");

        JTCorreo_Electronico.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        JTCorreo_Electronico.setPreferredSize(new java.awt.Dimension(15, 30));

        JLCorreoElectronico.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLCorreoElectronico.setText("Correo electronico");

        JTTelefono.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        JTTelefono.setPreferredSize(new java.awt.Dimension(15, 30));

        JLNumeral.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLNumeral.setText("#");

        CBLetras2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CBLetras2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "A", "B", "C", "D", "E" }));

        JCBIS.setText("Bis");

        JTNumero2.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N

        CBTipo_Via1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CBTipo_Via1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calle", "Carrera", "Transversal", "Diagonal", "Avenida" }));

        JLBarrio.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLBarrio.setText("Barrio");

        JTNumero_Principal1.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N

        JLRaya.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLRaya.setText("-");

        JTNumero1.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N

        CBBarrio.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CBBarrio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Antonio Nariño", "Balmoral", "Bella Vista", "Bonet", "Bosque Bonnet", "Callejón de Bonet", "Carlos Lleras", "Cedritos", "Ciudad Eben-ezer", "Ciudad Jardín", "Ciudadela Comfenalco", "Coburgo", "Comboy", "Conjunto Cerrado San Martín de Los Olivos", "Conjunto Residencial Asoveinte", "Conjunto Residencial Balcones de San José", "Conjunto Residencial Villa Rosita", "Diagonal 17", "Eben Ezer", "El Caney", "El Edén", "El Lucero", "El Manantial", "El Oasis", "El Progreso", "El Rosal", "El Tejar", "Emilio Sierra", "Fontanar", "Fusacat", "Gaitán I", "Gaitán II", "Gran Colombia", "Independencia", "José Antonio Galán", "La Cabaña", "La Esmeralda", "La Florida", "La Independencia", "La Palma", "La Pampa", "La Primavera", "La Venta", "Leidy Di", "Llano Grande", "Llano Largo", "Llano Verde", "Los Andes", "Los Fundadores", "Los Girasoles", "Los Robles", "Los Sauces", "Luxemburgo", "Maíz Amarillo", "Mandalay", "Manila", "Marsella", "Mi Tesoro", "Monte Verde", "Nueva Campiña", "Nueva Esperanza", "Nuevo Balmoral", "Olaya", "Parques de Occidente Etapas I y II", "Pekín", "Piedra Grande", "Potosí", "Porvenir La Salle", "Quintas de Balmoral", "San Antonio", "San Diego La Venta", "San Francisco", "San Jorge", "San Mateo", "Santa Ana Campestre", "Santa Anita", "Santa Clara", "Santa Librada", "Santa María de Los Ángeles", "Santander", "Siboney", "Teresita I", "Teresita II", "Urbanización Altos de Pekín", "Urbanización Cádiz", "Urbanización Cambulos", "Urbanización El Oasis", "Urbanización La Primavera", "Urbanización Las Brisas", "Urbanización Nueva Campiña", "Urbanización Parques de Occidente Etapas I y II", "Urbanización Pedregal de San Luis", "Urbanización Villa Alix", "Urbanización Los Girasoles", "Urbanización San Diego La Venta", "Urbanización Santa Anita", "Urbanización Siboney", "Urbanización Teresita I", "Urbanización Teresita II", "Urbanización Villa Rosita", "Urbanización Villas de San Diego I", "Urbanización Villas de San Diego II", "Urbanización Villas de San José", "Urbanización Villas del Rosario", "Urbanización Villa Natalia", "Urbanización Villa Rosalía", "Urbanización Villa Sutagaos", "Villa Alix", "Villa Aranzazu", "Villa Armerita", "Villa Celeste", "Villa Country", "Villa de Los Sutagaos", "Villa Natalia", "Villa Rosalía", "Villas de San Diego I", "Villas de San Diego II", "Villas de La Pampa" }));

        JLDireccion1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLDireccion1.setText("Direccion");

        CBOrientacion1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CBOrientacion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Este", "Oeste", "Sur", "Norte" }));

        BTNResgistrarse.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        BTNResgistrarse.setText("Registrar");
        BTNResgistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNResgistrarseActionPerformed(evt);
            }
        });

        CBLetras1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CBLetras1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "A", "B", "C", "D", "E" }));

        JLSeguroMedico.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLSeguroMedico.setText("Especialidad");

        CBEspecialidad.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CBEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicina Interna", "Pediatría", "Ginecología y Obstetricia", "Cirugía General", "Anestesiología", "Cardiología", "Neurología", "Traumatología y Ortopedia", "Dermatología", "Oftalmología", "Otorrinolaringología", "Neumología", "Urología", "Endocrinología", "Gastroenterología", "Nefrología", "Psiquiatría", "Oncología", "Reumatología", "Radiología" }));

        JLDatosCuenta.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        JLDatosCuenta.setText("Datos de la Cuenta");

        JLUsuario.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLUsuario.setText("Usuario");

        JTUsuario.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N

        BTNmostrar.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        BTNmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNmostrarActionPerformed(evt);
            }
        });

        JPConfirmarContraseña.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        JPConfirmarContraseña.setPreferredSize(new java.awt.Dimension(15, 30));

        JPContraseña.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        JPContraseña.setPreferredSize(new java.awt.Dimension(15, 30));

        JLContraseña.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLContraseña.setText("Contraseña");

        JLConfirmarContraseña.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLConfirmarContraseña.setText("Confirmar Contraseña");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTnombre_1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLnombre_1))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLnombre_2)
                                    .addComponent(JTnombre_2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTapellido_1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JLapellido_1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JLapellido_2))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(590, 590, 590)
                                        .addComponent(JTapellido_2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(CBTipo_Via1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(JTNumero_Principal1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addComponent(JCBIS)
                                                .addGap(18, 18, 18)
                                                .addComponent(CBLetras1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(CBOrientacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(JLNumeral))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(JLTipo_Documento)
                                                    .addComponent(CBTipo_Documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(70, 70, 70)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(JTNumero_Documento, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(JLNumero_Documento))))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JSFecha_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(JLFecha_Nacimiento)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(JTNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(CBLetras2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(JLRaya)
                                                .addGap(18, 18, 18)
                                                .addComponent(JTNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JLConfirmarContraseña)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(JPConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(BTNmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(131, 131, 131)
                                                .addComponent(JLContraseña)
                                                .addGap(18, 18, 18)
                                                .addComponent(JPContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JLUsuario)
                                        .addGap(18, 18, 18)
                                        .addComponent(JTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JLDatosCuenta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTNResgistrarse)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(JLBarrio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CBBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JLSeguroMedico)
                                .addGap(18, 18, 18)
                                .addComponent(CBEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JLCorreoElectronico)
                                .addGap(18, 18, 18)
                                .addComponent(JTCorreo_Electronico, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(JLNumero_Telefono)
                                .addGap(18, 18, 18)
                                .addComponent(JTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JLDatosContacto)
                            .addComponent(JLDatos_Usuario))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLDatos_Usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTnombre_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLnombre_2)
                            .addComponent(JLnombre_1)
                            .addComponent(JLapellido_1)
                            .addComponent(JLapellido_2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTnombre_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTapellido_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTapellido_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLTipo_Documento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBTipo_Documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLFecha_Nacimiento)
                            .addComponent(JLNumero_Documento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTNumero_Documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSFecha_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(JLDireccion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBIS)
                    .addComponent(JTNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBTipo_Via1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNumeral)
                    .addComponent(JLRaya)
                    .addComponent(JTNumero_Principal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBOrientacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBLetras1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBLetras2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLBarrio)
                    .addComponent(CBBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLSeguroMedico)
                    .addComponent(CBEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(JLDatosContacto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLCorreoElectronico)
                    .addComponent(JTCorreo_Electronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNumero_Telefono)
                    .addComponent(JTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(BTNResgistrarse))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(JLDatosCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLUsuario)
                            .addComponent(JTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLContraseña)
                            .addComponent(JPContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JLConfirmarContraseña)
                                .addComponent(JPConfirmarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BTNmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNResgistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNResgistrarseActionPerformed
        String contra = new String(JPContraseña.getPassword());
        String Ccontra = new String(JPConfirmarContraseña.getPassword());
        //Verificamos si todos los campos estan completos:
        if (!JTnombre_1.getText().equals("") && !JTapellido_1.getText().equals("") && !JTNumero_Documento.getText().equals("")
                && !JTNumero_Principal1.getText().equals("") && !JTCorreo_Electronico.getText().equals("") && !JTUsuario.getText().equals("")
                && !contra.equals("") && contra.equals(Ccontra)) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas segur@ de enviar los datos?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                String Bis = "";
                if (JCBIS.isSelected()) {
                    Bis = "Bis";
                }
                if (U.buscarExitenciadeUsuario(Integer.parseInt(JTNumero_Documento.getText()))) {
                    JOptionPane.showMessageDialog(null, "Ya hay un usuario existente", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String Direccion = CrearCuentaAdministrador.direccion(CBTipo_Via1.getSelectedItem().toString().trim(), JTNumero_Principal1.getText().trim(), Bis.trim(), CBLetras1.getSelectedItem().toString().trim(), CBOrientacion1.getSelectedItem().toString().trim(), JTNumero1.getText().trim(), CBLetras2.getSelectedItem().toString().trim(), JTNumero2.getText().trim());
                    Date FechaNacimiento = (Date) JSFecha_Nacimiento.getValue();
                    Medico M = new Medico(JTnombre_1.getText(), JTnombre_2.getText(), JTapellido_1.getText(), JTapellido_2.getText(), CBTipo_Documento.getSelectedItem().toString(), Integer.parseInt(JTNumero_Documento.getText()), FechaNacimiento, JTCorreo_Electronico.getText(), JTTelefono.getText(), Direccion, CBBarrio.getSelectedItem().toString(), JTUsuario.getText(), contra, CBEspecialidad.getSelectedItem().toString());
                    M.registrar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTNResgistrarseActionPerformed

    private void BTNmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNmostrarActionPerformed
        estado = !estado;
        if (estado) {
            BTNmostrar.setText("Ocultar");
            JPContraseña.setEchoChar((char) 0);
            JPConfirmarContraseña.setEchoChar((char) 0);
        } else {
            BTNmostrar.setText("Mostrar");
            JPConfirmarContraseña.setEchoChar('•');
            JPContraseña.setEchoChar('•');
        }

    }//GEN-LAST:event_BTNmostrarActionPerformed
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

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearCuentaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCuentaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCuentaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCuentaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCuentaMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNResgistrarse;
    private javax.swing.JButton BTNmostrar;
    private javax.swing.JComboBox<String> CBBarrio;
    private javax.swing.JComboBox<String> CBEspecialidad;
    private javax.swing.JComboBox<String> CBLetras1;
    private javax.swing.JComboBox<String> CBLetras2;
    private javax.swing.JComboBox<String> CBOrientacion1;
    private javax.swing.JComboBox<String> CBTipo_Documento;
    private javax.swing.JComboBox<String> CBTipo_Via1;
    private javax.swing.JCheckBox JCBIS;
    private javax.swing.JLabel JLBarrio;
    private javax.swing.JLabel JLConfirmarContraseña;
    private javax.swing.JLabel JLContraseña;
    private javax.swing.JLabel JLCorreoElectronico;
    private javax.swing.JLabel JLDatosContacto;
    private javax.swing.JLabel JLDatosCuenta;
    private javax.swing.JLabel JLDatos_Usuario;
    private javax.swing.JLabel JLDireccion1;
    private javax.swing.JLabel JLFecha_Nacimiento;
    private javax.swing.JLabel JLNumeral;
    private javax.swing.JLabel JLNumero_Documento;
    private javax.swing.JLabel JLNumero_Telefono;
    private javax.swing.JLabel JLRaya;
    private javax.swing.JLabel JLSeguroMedico;
    private javax.swing.JLabel JLTipo_Documento;
    private javax.swing.JLabel JLUsuario;
    private javax.swing.JLabel JLapellido_1;
    private javax.swing.JLabel JLapellido_2;
    private javax.swing.JLabel JLnombre_1;
    private javax.swing.JLabel JLnombre_2;
    private javax.swing.JPasswordField JPConfirmarContraseña;
    private javax.swing.JPasswordField JPContraseña;
    private javax.swing.JSpinner JSFecha_Nacimiento;
    private javax.swing.JTextField JTCorreo_Electronico;
    private javax.swing.JTextField JTNumero1;
    private javax.swing.JTextField JTNumero2;
    private javax.swing.JTextField JTNumero_Documento;
    private javax.swing.JTextField JTNumero_Principal1;
    private javax.swing.JTextField JTTelefono;
    private javax.swing.JTextField JTUsuario;
    private javax.swing.JTextField JTapellido_1;
    private javax.swing.JTextField JTapellido_2;
    private javax.swing.JTextField JTnombre_1;
    private javax.swing.JTextField JTnombre_2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
