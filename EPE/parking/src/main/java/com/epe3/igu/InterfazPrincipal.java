package com.epe3.igu;
//Realizamos las Importaciones
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazPrincipal {
    private JFrame frame;

    public InterfazPrincipal() {
        frame = new JFrame("Interfaz Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Layout para centrar los botones
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Botón para abrir el JFrame "Medico"
        JButton btnMedico = new JButton("Medico");
        btnMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual e ir a la Interfaz Medico
                frame.dispose(); // Cierra la ventana actual
                VentanaMedico.main(null);
            }
        });
        panel.add(btnMedico, gbc);

        // Botón para abrir el JFrame "Reserva"
        JButton btnReserva = new JButton("Reserva");
        btnReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                VentanaReserva.main(null);
            }
        });
        gbc.gridy++;
        panel.add(btnReserva, gbc);

        // Botón para cerrar la ventana
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        gbc.gridy++;
        panel.add(btnCerrar, gbc);

        frame.add(panel);
        frame.setVisible(true);

    }

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal();
            }
        });
    }
}
