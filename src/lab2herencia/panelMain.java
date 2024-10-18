/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelMain extends JFrame {

    JPanel main = new JPanel();
    JPanel AgregarPlan = new JPanel();
    JPanel PagoPlan = new JPanel();
    JPanel AgregarAmigo = new JPanel();
    JPanel Listar = new JPanel();

    public panelMain() {
        this.setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Menu");
        initiateComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void initiateComponents() {
        colocarPaneles();
        colocarBotones();
    }

    private void colocarPaneles() {
        main.setLayout(null);
        main.setBackground(Color.CYAN);
        this.getContentPane().add(main);

        JLabel titulo = new JLabel("MENU");
        titulo.setBounds(150, 10, 100, 100);
        main.add(titulo);

    }

    private void colocarBotones() {
        JButton boton = new JButton("Agregar Plan");
        boton.setBounds(150, 80, 200, 40);
        boton.setEnabled(true);

        main.add(boton);
        JButton boton2 = new JButton("Pago Plan");
        boton2.setBounds(150, 130, 200, 40);
        boton2.setEnabled(true);
        main.add(boton2);
        JButton boton3 = new JButton("Agregar Amigo");
        boton3.setBounds(150, 180, 200, 40);
        boton3.setEnabled(true);
        main.add(boton3);
        JButton boton4 = new JButton("Listar");
        boton4.setBounds(150, 230, 200, 40);
        boton4.setEnabled(true);
        main.add(boton4);
        JButton boton5 = new JButton("Salir");
        boton5.setBounds(150, 280, 200, 40);
        boton5.setEnabled(true);
        main.add(boton5);

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == boton) {
                    AgregarPlan.setVisible(true);
                    System.out.println("Agregar Plan button clicked");
                } else if (ae.getSource() == boton2) {
                    System.out.println("Pago Plan button clicked");
                } else if (ae.getSource() == boton3) {
                    System.out.println("Agregar Amigo button clicked");
                } else if (ae.getSource() == boton4) {
                    System.out.println("Listar button clicked");
                    
                } else if (ae.getSource() == boton5) {
                    System.out.println("Salir button clicked");
                    System.exit(0);
                }
            }
        };
        boton.addActionListener(buttonListener);
        boton2.addActionListener(buttonListener);
        boton3.addActionListener(buttonListener);
        boton4.addActionListener(buttonListener);
        boton5.addActionListener(buttonListener);
    }

}
