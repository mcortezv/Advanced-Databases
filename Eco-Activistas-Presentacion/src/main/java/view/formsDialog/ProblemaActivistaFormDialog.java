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
    private TextField idProblemaField;
    private TextField idActivistaField;
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
                createProblemaActivista();
            }
            case 1 -> {
                setTitle("Buscar ProblemaActivista");
                readProblemaActivista();
            }
            case 2 -> {
                setTitle("Eliminar ProblemaActivista");
                deleteProblemaActivista();
            }
            default -> {}
        }
    }

    public void createProblemaActivista() {
        setSize(500, 300);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idProblemaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idProblemaPanel.add(new JLabel("Problema ID:         "));
        idProblemaField = new TextField(20);
        idProblemaPanel.add(idProblemaField);
        idProblemaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idActivistaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idActivistaPanel.add(new JLabel("Activista ID:                "));
        idActivistaField = new TextField(20);
        idActivistaPanel.add(idActivistaField);
        idActivistaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            try {
                if (controller.getProblemaActivistaController().asignarProblemaActivista(Integer.parseInt(idProblemaField.getText().trim()),
                        Integer.parseInt(idActivistaField.getText().trim()))) {
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
        centerPanel.add(idProblemaPanel);
        centerPanel.add(idActivistaPanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readProblemaActivista() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Problema ID:   "));
        idProblemaField = new TextField(20);
        idPanel.add(idProblemaField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        idPanel.add(new JLabel("Activista ID:   "));
        idActivistaField = new TextField(20);
        idPanel.add(idActivistaField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnSearch = new Button("Buscar");
        btnSearch.addActionListener(e -> {
            try {
                ProblemaActivista problemaActivista = controller.getProblemaActivistaController().obtenerRelacion(Integer.parseInt(idProblemaField.getText().trim()),
                        Integer.parseInt(idActivistaField.getText().trim()));
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


    public void deleteProblemaActivista() {
        setSize(400, 250);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Problema ID:   "));
        idProblemaField = new TextField(20);
        idPanel.add(idProblemaField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        idPanel.add(new JLabel("Activista ID:   "));
        idActivistaField = new TextField(20);
        idPanel.add(idActivistaField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnDelete = new Button("Eliminar");
        btnDelete.addActionListener(e -> {
            try {
                if (controller.getProblemaActivistaController().eliminarRelacion(Integer.parseInt(idProblemaField.getText().trim()),
                        Integer.parseInt(idActivistaField.getText().trim()))) {
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