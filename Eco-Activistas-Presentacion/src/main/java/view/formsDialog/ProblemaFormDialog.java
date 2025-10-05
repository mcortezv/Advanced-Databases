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
    private TextField nombreField;
    private TextField descripcionField;
    private TextField idClienteField;
    private TextField estadoField;
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
                createMateria();
            }
            case 1 -> {
                setTitle("Buscar Problema");
                readMateria();
            }
            case 2 -> {
                setTitle("Actualizar Problema");
                updateMateria();
            }
            case 3 -> {
                setTitle("Eliminar Problema");
                deleteMateria();
            }
            default -> {}
        }
    }

    public void createMateria() {
        setSize(500, 400);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nombrePanel.add(new JLabel("Fecha Inicio:      "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel descripcionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descripcionPanel.add(new JLabel("Fecha Fin:   "));
        descripcionField = new TextField(20);
        descripcionPanel.add(descripcionField);
        descripcionPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel estadoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        estadoPanel.add(new JLabel("Estado:   "));
        estadoField = new TextField(20);
        estadoPanel.add(estadoField);
        estadoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idClientePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idClientePanel.add(new JLabel("Id Cliente:   "));
        idClienteField = new TextField(20);
        idClientePanel.add(idClienteField);
        idClientePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            if (!nombreField.getText().trim().isBlank() || !descripcionField.getText().trim().isBlank()) {
                if (controller.agregarProblema(nombreField.getText().trim(),
                        descripcionField.getText().trim(),
                        estadoField.getText().trim(),
                        Integer.parseInt(idClienteField.getText().trim()))) {
                    JOptionPane.showMessageDialog(centerPanel, "Problema agregada con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "La Problema no se pudo agregar");
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(descripcionPanel);
        centerPanel.add(estadoPanel);
        centerPanel.add(idClientePanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readMateria() {
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
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        southPanel.add(btnSearch);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void updateMateria() {
        setSize(500, 460);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Problema ID:        "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nombrePanel.add(new JLabel("Fecha Inicio:      "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel descripcionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descripcionPanel.add(new JLabel("Fecha Fin:   "));
        descripcionField = new TextField(20);
        descripcionPanel.add(descripcionField);
        descripcionPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel estadoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        estadoPanel.add(new JLabel("Estado:   "));
        estadoField = new TextField(20);
        estadoPanel.add(estadoField);
        estadoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idClientePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idClientePanel.add(new JLabel("Id Cliente:   "));
        idClienteField = new TextField(20);
        idClientePanel.add(idClienteField);
        idClientePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnUpdate = new Button("Actualizar");
        btnUpdate.addActionListener(e -> {
            try {
                if (controller.actualizarProblema(Integer.parseInt(idField.getText().trim()),
                        nombreField.getText().trim(),
                        descripcionField.getText().trim(),
                        estadoField.getText().trim(),
                        Integer.parseInt(idClienteField.getText().trim()))) {
                    JOptionPane.showMessageDialog(centerPanel, "Problema actualizada con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "La Problema no se pudo actualizar");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(descripcionPanel);
        centerPanel.add(estadoPanel);
        centerPanel.add(idClientePanel);
        southPanel.add(btnUpdate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void deleteMateria() {
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
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        southPanel.add(btnDelete);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

}
