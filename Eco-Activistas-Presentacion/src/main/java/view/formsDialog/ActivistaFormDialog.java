/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.formsDialog;
import controllers.ActivistaController;
import controllers.MainController;
import models.Activista;
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
public final class ActivistaFormDialog extends Dialog {
    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    private TextField idField;
    private TextField nombreField;
    private TextField telefonoField;
    private TextField correoField;
    private TextField especialidadField;
    private ActivistaController controller;

    public ActivistaFormDialog(MainFrame owner, MainController controller, int option) {
        super(owner, " ", true);
        setResizable(false);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.controller = controller.getActivistaController();
        switch (option) {
            case 0 -> {
                setTitle("Agregar Activista");
                createTutor();
            }
            case 1 -> {
                setTitle("Buscar Activista");
                readTutor();
            }
            case 2 -> {
                setTitle("Actualizar Activista");
                updateTutor();
            }
            case 3 -> {
                setTitle("Eliminar Activista");
                deleteTutor();
            }
            default -> {}
        }
    }

    public void createTutor() {
        setSize(500, 350);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nombrePanel.add(new JLabel("Nombre Completo:        "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel telefonoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        telefonoPanel.add(new JLabel("Telefono:                         "));
        telefonoField = new TextField(20);
        telefonoPanel.add(telefonoField);
        telefonoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel correoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        correoPanel.add(new JLabel("Fecha Ingreso:                             "));
        correoField = new TextField(20);
        correoPanel.add(correoField);
        correoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            if (!nombreField.getText().trim().isBlank() || !telefonoField.getText().trim().isBlank() ||
                    !correoField.getText().trim().isBlank() | !especialidadField.getText().trim().isBlank()) {
                if (controller.agregarActivista(nombreField.getText().trim(),
                        telefonoField.getText().trim(),
                        correoField.getText().trim())) {
                    JOptionPane.showMessageDialog(centerPanel, "Activista agregado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Activista no se pudo agregar");
                }
                dispose();
            } else  {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(telefonoPanel);
        centerPanel.add(correoPanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readTutor() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("ID del Activista:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnSearch = new Button("Buscar");
        btnSearch.addActionListener(e -> {
            try {
                Activista activista = controller.obtenerActivista(Integer.parseInt(idField.getText().trim()));
                if (activista != null) {
                    JOptionPane.showMessageDialog(centerPanel, activista.toString());
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "La Activista no se pudo encontrar");
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

    public void updateTutor() {
        setSize(500, 460);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("ID del Tutor:                    "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nombrePanel.add(new JLabel("Nombre Completo:        "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel telefonoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        telefonoPanel.add(new JLabel("Telefono:                         "));
        telefonoField = new TextField(20);
        telefonoPanel.add(telefonoField);
        telefonoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel correoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        correoPanel.add(new JLabel("Fecha Ingreso:                             "));
        correoField = new TextField(20);
        correoPanel.add(correoField);
        correoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnUpdate = new Button("Actualizar");
        btnUpdate.addActionListener(e -> {
            try {
                if (controller.actualizarActivista(Integer.parseInt(idField.getText().trim()),
                        nombreField.getText().trim(),
                        telefonoField.getText().trim(),
                        correoField.getText().trim())) {
                    JOptionPane.showMessageDialog(centerPanel, "Activista actualizado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Activista no se pudo actualizar");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(telefonoPanel);
        centerPanel.add(correoPanel);
        southPanel.add(btnUpdate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void deleteTutor() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("ID del Activista:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnDelete = new Button("Eliminar");
        btnDelete.addActionListener(e -> {
            try {
                if (controller.eliminarActivista(Integer.parseInt(idField.getText().trim()))) {
                    JOptionPane.showMessageDialog(centerPanel, "Activista eliminado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Activista no se pudo eliminar");
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