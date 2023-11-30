package com.epe3.igu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaReserva extends JFrame {
    private JTable tabla;
    private JButton btnCerrar;

    public VentanaReserva() {
        setTitle("Ventana de Reserva");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Datos para la tabla (solo como ejemplo)
        String[][] datos = {
            {"Dr. López", "Juan Pérez", "Cardiología", "8:00 - 10:00"},
            {"Dr. García", "María Gómez", "Dermatología", "10:30 - 12:30"},
            // Puedes agregar más datos aquí...
        };

        // Nombres de las columnas
        String[] columnas = {"Nombre Medico", "Nombre Paciente", "Especialidad", "Horas Disponibles"};

        // Crear el modelo de tabla con los datos y columnas
        DefaultTableModel modeloTabla = new DefaultTableModel(datos, columnas);
        tabla = new JTable(modeloTabla);

        // Agregar la tabla a un JScrollPane para que sea desplazable
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane);

        // Crear y agregar el botón "Cerrar"
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> {
            dispose(); // Cierra la ventana al presionar el botón "Cerrar"
        });
        add(btnCerrar, "South");

        setVisible(true);
    }

    public static void main(String[] args) {
        // Para ejecutar la ventana desde el método main
        SwingUtilities.invokeLater(() -> new VentanaReserva());
    }
}