package com.epe3.igu;

//Realizo las importaciones
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaMedico extends JFrame {
    private JLabel labelNombreMedico, labelNombrePaciente, labelEspecialidad, labelHorasDisponibles, labelValorHora;
    private JComboBox<String> comboNombreMedico, comboEspecialidad, comboHorasDisponibles;
    private JTextField txtNombrePaciente;
    private JButton btnGuardar, btnCancelar;
    //Arreglo donde guardare la informacion
    private ArrayList<String> datosGuardados;

    public VentanaMedico() {
        super("Ventana del Medico");
        //Instanciando arraylist
        datosGuardados = new ArrayList<>();

        // Creación de los componentes
        labelNombreMedico = new JLabel("Nombre del Medico: ");
        comboNombreMedico = new JComboBox<>(new String[]{"Juan Meza", "Pedro Pascal", "Juan Fernandez", "Ricardo Araya", "Magdalena Montes", "Isidora Goyenechea"}); // Ejemplo de opciones
        labelNombrePaciente = new JLabel("Nombre del Paciente: ");
        txtNombrePaciente = new JTextField(20);
        labelEspecialidad = new JLabel("Especialidad: ");
        comboEspecialidad = new JComboBox<>(new String[]{"Medicina General", "Pediatría", "Traumatología", "Dermatología", "Oftalmología", "Otorrinolaringología", "Ginecología"}); // Ejemplo de opciones
        labelHorasDisponibles = new JLabel("Horas Disponibles: ");
        comboHorasDisponibles = new JComboBox<>(new String[]{"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"}); // Ejemplo de opciones
        labelValorHora = new JLabel("Valor hora: $7.000");
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        // Configuración del diseño del JFrame
        setLayout(new GridLayout(6, 2));
        add(labelNombreMedico);
        add(comboNombreMedico);
        add(labelNombrePaciente);
        add(txtNombrePaciente);
        add(labelEspecialidad);
        add(comboEspecialidad);
        add(labelHorasDisponibles);
        add(comboHorasDisponibles);
        add(labelValorHora);
        add(new JLabel()); // Espacio en blanco para mantener la disposición
        add(btnGuardar);
        add(btnCancelar);

        // Acción del botón "Guardar"
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Invoco metodo que guarda los datos
                guardarDatos();
                //Cierro ventana
                dispose();
                //Abro ventana Reserva
                VentanaReserva.main(null);
            }
        });

        // Acción del botón "Cancelar"
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual
                dispose(); 
                InterfazPrincipal.main(null); // Abre la Interfaz Principal
            }
        });

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true); // Hacer visible la ventana
    }

    // Método para guardar los datos en el ArrayList
    private void guardarDatos() {
        //Tomo los datos ingresados al formulario y los guardo en variables
        String nombreMedico = (String) comboNombreMedico.getSelectedItem();
        String nombrePaciente = txtNombrePaciente.getText();
        String especialidad = (String) comboEspecialidad.getSelectedItem();
        String horaDisponible = (String) comboHorasDisponibles.getSelectedItem();

        // Agrego las variables con los datos guardados en el ArrayList
        datosGuardados.add("Nombre del Médico: " + nombreMedico);
        datosGuardados.add("Nombre del Paciente: " + nombrePaciente);
        datosGuardados.add("Especialidad: " + especialidad);
        datosGuardados.add("Hora Disponible: " + horaDisponible);

        // Reviso en Terminal que los datos se guarden
        System.out.println("Datos guardados: " + datosGuardados);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaMedico();
            }
        });
    }
}
