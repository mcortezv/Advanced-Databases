/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.formsDialog;
import controllers.MainController;
import models.ProblemaActivista;
import view.MainFrame;
import view.styles.Button;
import view.styles.Dialog;
import view.styles.TextField;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Cortez Manuel;
 */
public final class ProblemaActivistaFormDialog extends Dialog {
    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    private TextField idField;
    private JComboBox diaCombo;
    private TextField horaInicioField;
    private TextField horaFinField;
    private TextField idTutorField;
    private MainController controller;

    public ProblemaActivistaFormDialog(MainFrame owner, MainController controller, int option) {
        super(owner, " ", true);
        setResizable(false);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.controller = controller;
        switch (option) {
            case 0 -> {
                setTitle("Agregar ProblemaActivista");
                createHorario();
            }
            case 1 -> {
                setTitle("Buscar ProblemaActivista");
                readHorario();
            }
            case 2 -> {
                setTitle("Eliminar ProblemaActivista");
                deleteHorario();
            }
            default -> {}
        }
    }

    public void createHorario() {
        setSize(500, 300);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel horaInicioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horaInicioPanel.add(new JLabel("Problema ID:         "));
        horaInicioField = new TextField(20);
        horaInicioPanel.add(horaInicioField);
        horaInicioPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));


        JPanel idTutorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idTutorPanel.add(new JLabel("Activista ID:                "));
        idTutorField = new TextField(20);
        idTutorPanel.add(idTutorField);
        idTutorPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            try {
                if (controller.getProblemaActivistaController().asignarProblemaActivista(Integer.parseInt(horaFinField.getText().trim()),
                        Integer.parseInt(idTutorField.getText().trim()))) {
                    JOptionPane.showMessageDialog(centerPanel, "ProblemaActivista agregado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El ProblemaActivista no pudo agregarse");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(horaInicioPanel);
        centerPanel.add(idTutorPanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readHorario() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Problema ID:   "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        idPanel.add(new JLabel("Activista ID:   "));
        idTutorField = new TextField(20);
        idPanel.add(idTutorField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnSearch = new Button("Buscar");
        btnSearch.addActionListener(e -> {
            try {
                ProblemaActivista problemaActivista = controller.getProblemaActivistaController().obtenerRelacion(Integer.parseInt(idField.getText().trim()),
                        Integer.parseInt(idTutorField.getText().trim()));
                if (problemaActivista != null) {
                    JOptionPane.showMessageDialog(centerPanel, problemaActivista.toString());
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "ProblemaActivista no encontrado");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        southPanel.add(btnSearch);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }


    public void deleteHorario() {
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Problema ID:   "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        idPanel.add(new JLabel("Activista ID:   "));
        idTutorField = new TextField(20);
        idPanel.add(idTutorField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnDelete = new Button("Eliminar");
        btnDelete.addActionListener(e -> {
            try {
                if (controller.getProblemaActivistaController().eliminarRelacion(Integer.parseInt(idField.getText().trim()),
                        Integer.parseInt(idTutorField.getText().trim()))) {
                    JOptionPane.showMessageDialog(centerPanel, "ProblemaActivista eliminado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El ProblemaActivista no se pudo eliminar");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(idPanel);
        southPanel.add(btnDelete);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
}