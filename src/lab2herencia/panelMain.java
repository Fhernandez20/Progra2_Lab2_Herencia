/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2herencia;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelMain extends JFrame {

    private Plan plan;
    JPanel main = new JPanel();
    JPanel cards = new JPanel(new CardLayout());
    JPanel AgregarPlan = new JPanel();
    JPanel PagoPlan = new JPanel();
    JPanel AgregarAmigo = new JPanel();
    JPanel Listar = new JPanel();
    Tigo tigo = new Tigo();

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

        //Agregar PLan
        AgregarPlan.setLayout(null);
        AgregarPlan.setBackground(Color.LIGHT_GRAY);
        agregarBotonBack(AgregarPlan);

        JLabel labelPlan = new JLabel("Panel de Agregar Plan");
        labelPlan.setBounds(50, 20, 200, 100);
        JLabel samsung = new JLabel("Plan de Samsung: ");
        samsung.setBounds(50, 100, 200, 20);
        JLabel itunes = new JLabel("Plan de iTunes: ");
        itunes.setBounds(50, 130, 200, 20);
        AgregarPlan.add(labelPlan);
        AgregarPlan.add(samsung);
        AgregarPlan.add(itunes);

        JCheckBox checkboxSamsung = new JCheckBox("Escoger Plan Samsung");
        checkboxSamsung.setBounds(190, 100, 200, 20);
        AgregarPlan.add(checkboxSamsung);

        JCheckBox checkboxiTunes = new JCheckBox("Escoger Plan iTunes");
        checkboxiTunes.setBounds(190, 130, 200, 20);
        AgregarPlan.add(checkboxiTunes);

        JButton botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setBounds(50, 250, 200, 20);
        AgregarPlan.add(botonConfirmar);

        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePlanSelection(checkboxSamsung, checkboxiTunes);
            }
        });

        //PAGO PLAN
        PagoPlan.setLayout(null);
        JLabel labelPago = new JLabel("Panel de Pago Plan");
        labelPago.setBounds(150, 10, 200, 30);
        PagoPlan.add(labelPago);
        agregarBotonBack(PagoPlan);

        JLabel labelNumero = new JLabel("Ingrese su número:");
        labelNumero.setBounds(50, 50, 150, 30);
        PagoPlan.add(labelNumero);

        JTextField numeroField = new JTextField();
        numeroField.setBounds(200, 50, 150, 30);
        PagoPlan.add(numeroField);

        JLabel labelMins = new JLabel("Minutos usados:");
        labelMins.setBounds(50, 100, 150, 30);
        PagoPlan.add(labelMins);

        JTextField minsField = new JTextField();
        minsField.setBounds(200, 100, 150, 30);
        PagoPlan.add(minsField);

        JLabel labelMsgs = new JLabel("Mensajes usados:");
        labelMsgs.setBounds(50, 150, 150, 30);
        PagoPlan.add(labelMsgs);

        JTextField msgsField = new JTextField();
        msgsField.setBounds(200, 150, 150, 30);
        PagoPlan.add(msgsField);

        JButton buscarPlanBtn = new JButton("Buscar y Calcular Pago");
        buscarPlanBtn.setBounds(150, 200, 200, 30);
        PagoPlan.add(buscarPlanBtn);

        agregarBotonBack(PagoPlan);
        AgregarAmigo.setLayout(null);
        JLabel labelAmigo = new JLabel("Panel de Agregar Amigo");
        labelAmigo.setBounds(150, 10, 200, 30);
        AgregarAmigo.add(labelAmigo);
        agregarBotonBack(AgregarAmigo);

        JButton botonConseguirNum = new JButton("Obtener Número");
        botonConseguirNum.setBounds(200, 100, 150, 30); // Posición y tamaño del botón
        PagoPlan.add(botonConseguirNum);

        botonConseguirNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero = Integer.parseInt(numeroField.getText());
                int mins = Integer.parseInt(minsField.getText());
                int msgs = Integer.parseInt(msgsField.getText());

                double pago = tigo.pagoPlan(numero, mins, msgs);

                if (pago == -1) {
                } else {

                }

            }

        });

        agregarBotonBack(PagoPlan);

        //LISTA
        Listar.setLayout(null);
        JLabel labelListar = new JLabel("Panel de Listar");
        labelListar.setBounds(150, 10, 200, 30);
        agregarBotonBack(Listar);
        Listar.add(labelListar);

        cards.add(main, "Menu");
        cards.add(AgregarPlan, "AgregarPlan");
        cards.add(PagoPlan, "PagoPlan");
        cards.add(AgregarAmigo, "AgregarAmigo");
        cards.add(Listar, "Listar");

        this.getContentPane().add(cards);

        JLabel titulo = new JLabel("MENU");
        titulo.setBounds(150, 10, 100, 100);
        main.add(titulo);
    }

    private void handlePlanSelection(JCheckBox checkboxSamsung, JCheckBox checkboxiTunes) {
        String selectedPlans = "Planes seleccionados:\n";
        boolean isSamsungSelected = checkboxSamsung.isSelected();
        boolean isIphoneSelected = checkboxiTunes.isSelected();

        if (isSamsungSelected) {
            selectedPlans += "- Plan de Samsung\n";
        }
        if (isIphoneSelected) {
            selectedPlans += "- Plan de IPhone\n";
        }

        if (!isSamsungSelected && !isIphoneSelected) {
            selectedPlans = "No se ha seleccionado ningún plan.";
        } else if (isSamsungSelected && isIphoneSelected) {
            selectedPlans = "Solo puede seleccionar un plan.";
        }

        JOptionPane.showMessageDialog(null, selectedPlans);

        if (isSamsungSelected) {
            collectUserData("Samsung");
        } else if (isIphoneSelected) {
            collectUserData("IPhone");
        }
    }

    private void collectUserData(String tipoPlan) {
        JTextField numberField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();

        int numberOption = JOptionPane.showConfirmDialog(null, numberField, "Ingresar su número", JOptionPane.OK_CANCEL_OPTION);
        if (numberOption == JOptionPane.OK_OPTION) {
            int nameOption = JOptionPane.showConfirmDialog(null, nameField, "Ingresar su nombre", JOptionPane.OK_CANCEL_OPTION);
            if (nameOption == JOptionPane.OK_OPTION) {
                int emailOption = JOptionPane.showConfirmDialog(null, emailField, "Ingresar su Email", JOptionPane.OK_CANCEL_OPTION);
                if (emailOption == JOptionPane.OK_OPTION) {
                    try {
                        String numStr = numberField.getText();
                        int numero = Integer.parseInt(numStr);
                        String nombre = nameField.getText();
                        String email = emailField.getText();

                        if ("Samsung".equals(tipoPlan)) {
                            plan = new PlanSamsung(numero, nombre, email);
                        } else {
                            plan = new PlanIPhone(numero, nombre, email);
                        }
                        JOptionPane.showMessageDialog(null, "Plan creado exitosamente");
                        CardLayout cl = (CardLayout) (cards.getLayout());
                        cl.show(cards, "Menu");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
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
                CardLayout cl = (CardLayout) (cards.getLayout());
                if (ae.getSource() == boton) {
                    cl.show(cards, "AgregarPlan");

                } else if (ae.getSource() == boton2) {
                    cl.show(cards, "PagoPlan");

                } else if (ae.getSource() == boton3) {
                    cl.show(cards, "AgregarAmigo");

                } else if (ae.getSource() == boton4) {
                    cl.show(cards, "Listar");
                } else if (ae.getSource() == boton5) {
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

    public void agregarBotonBack(JPanel panel) {
        JButton botonBack = new JButton("BACK");
        botonBack.setBounds(10, 420, 100, 30);
        botonBack.setEnabled(true);
        panel.add(botonBack);

        botonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, "Menu");
            }
        });
    }
}
