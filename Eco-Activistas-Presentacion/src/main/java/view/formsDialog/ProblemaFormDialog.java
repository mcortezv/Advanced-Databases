/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.formsDialog;
import controllers.MainController;
import controllers.ProblemaController;
import models.Problema;
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
public final class ProblemaFormDialog extends Dialog {
    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    private TextField idField;
    private TextField fechaInicioField;
    private TextField fechaFinField;
    private TextField estadoField;
    private TextField idActivistaField;
    private ProblemaController controller;

    public ProblemaFormDialog(MainFrame owner, MainController controller, int option) {
        super(owner, " ", true);
        setResizable(false);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.controller = controller.getProblemaController();
        switch (option) {
            case 0 -> {
                setTitle("Agregar Problema");
                createProblema();
            }
            case 1 -> {
                setTitle("Buscar Problema");
                readProblema();
            }
            case 2 -> {
                setTitle("Actualizar Problema");
                updateProblema();
            }
            case 3 -> {
                setTitle("Eliminar Problema");
                deleteProblema();
            }
            default -> {}
        }
    }

    public void createProblema() {
        setSize(500, 400);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel fechaInicioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fechaInicioPanel.add(new JLabel("Fecha Inicio:      "));
        fechaFinField = new TextField(20);
        fechaInicioPanel.add(fechaFinField);
        fechaInicioPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel fechaFinPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fechaFinPanel.add(new JLabel("Fecha Fin:   "));
        fechaFinField = new TextField(20);
        fechaFinPanel.add(fechaFinField);
        fechaFinPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel estadoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        estadoPanel.add(new JLabel("Estado:   "));
        estadoField = new TextField(20);
        estadoPanel.add(estadoField);
        estadoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idActivistaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idActivistaPanel.add(new JLabel("Id Cliente:   "));
        idActivistaField = new TextField(20);
        idActivistaPanel.add(idActivistaField);
        idActivistaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            if (!fechaInicioField.getText().trim().isBlank() || !fechaFinField.getText().trim().isBlank() ||
                    !estadoField.getText().trim().isBlank() || !idActivistaField.getText().trim().isBlank()) {
                try {
                    if (controller.agregarProblema(fechaInicioField.getText().trim(),
                            fechaFinField.getText().trim(),
                            estadoField.getText().trim(),
                            Integer.parseInt(idActivistaField.getText().trim()))) {
                        JOptionPane.showMessageDialog(centerPanel, "Problema agregada con exito");
                    } else {
                        JOptionPane.showMessageDialog(centerPanel, "La Problema no se pudo agregar");
                    }
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(centerPanel, "Ingrese un valor entero para el ID");
                }
            } else {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(fechaInicioPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(fechaFinPanel);
        centerPanel.add(estadoPanel);
        centerPanel.add(idActivistaPanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readProblema() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("ID del Problema:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnSearch = new Button("Buscar");
        btnSearch.addActionListener(e -> {
            try {
                Problema problema = controller.obtenerProblema(Integer.parseInt(idField.getText().trim()));
                if (problema != null) {
                    JOptionPane.showMessageDialog(centerPanel, problema.toString());
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "Problema no encontrada");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Ingrese un valor entero");
            }
        });

        centerPanel.add(idPanel);
        southPanel.add(btnSearch);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void updateProblema() {
        setSize(500, 460);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Problema ID:        "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel fechaInicioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fechaInicioPanel.add(new JLabel("Fecha Inicio:      "));
        fechaInicioField = new TextField(20);
        fechaInicioPanel.add(fechaInicioField);
        fechaInicioPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel fechaFinPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fechaFinPanel.add(new JLabel("Fecha Fin:   "));
        fechaFinField = new TextField(20);
        fechaFinPanel.add(fechaFinField);
        fechaFinPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel estadoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        estadoPanel.add(new JLabel("Estado:   "));
        estadoField = new TextField(20);
        estadoPanel.add(estadoField);
        estadoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idActivistaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idActivistaPanel.add(new JLabel("Id Cliente:   "));
        idActivistaField = new TextField(20);
        idActivistaPanel.add(idActivistaField);
        idActivistaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnUpdate = new Button("Actualizar");
        btnUpdate.addActionListener(e -> {
            if (!idField.getText().trim().isBlank() || !fechaInicioField.getText().trim().isBlank() ||
                    !fechaFinField.getText().trim().isBlank() || !estadoField.getText().trim().isBlank()||
                    !idActivistaField.getText().trim().isBlank()) {
                try {
                    if (controller.actualizarProblema(Integer.parseInt(idField.getText().trim()),
                            fechaInicioField.getText().trim(),
                            fechaFinField.getText().trim(),
                            estadoField.getText().trim(),
                            Integer.parseInt(idActivistaField.getText().trim()))) {
                        JOptionPane.showMessageDialog(centerPanel, "Problema actualizada con exito");
                    } else {
                        JOptionPane.showMessageDialog(centerPanel, "La Problema no se pudo actualizar");
                    }
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(centerPanel, "Ingrese un valor entero par el ID");
                }
            } else {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        centerPanel.add(fechaInicioPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(fechaFinPanel);
        centerPanel.add(estadoPanel);
        centerPanel.add(idActivistaPanel);
        southPanel.add(btnUpdate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void deleteProblema() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("ID del Problema:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnDelete = new Button("Eliminar");
        btnDelete.addActionListener(e -> {
            try {
                if (controller.eliminarProblema(Integer.parseInt(idField.getText().trim()))) {
                    JOptionPane.showMessageDialog(centerPanel, "Problema eliminada con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Problema no se pudo eliminar");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Ingrese un  valor entero");
            }
        });

        centerPanel.add(idPanel);
        southPanel.add(btnDelete);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

}
