/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.formsDialog;
import controllers.ClienteController;
import controllers.MainController;
import models.Cliente;
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
public final class ClienteFormDialog extends Dialog {
    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    private TextField idField;
    private TextField nombreField;
    private TextField direccionField;
    private TextField telefonoField;
    private ClienteController controller;

    public ClienteFormDialog(MainFrame owner, MainController controller, int option) {
        super(owner, " ", true);
        setResizable(false);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.controller = controller.getClienteController();
        switch (option) {
            case 0 -> {
                setTitle("Agregar Cliente");
                createCliente();
            }
            case 1 -> {
                setTitle("Buscar Cliente");
                readCliente();
            }
            case 2 -> {
                setTitle("Actualizar Cliente");
                updateCliente();
            }
            case 3 -> {
                setTitle("Eliminar Cliente");
                deleteCliente();
            }
            default -> {}
        }
    }

    public void createCliente() {
        setSize(500, 350);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nombrePanel.add(new JLabel("Nombre Completo:        "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel direccionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        direccionPanel.add(new JLabel("Direccion:          "));
        direccionField = new TextField(20);
        direccionPanel.add(direccionField);
        direccionPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel telefonoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        telefonoPanel.add(new JLabel("Telefonos:         "));
        telefonoField = new TextField(20);
        telefonoPanel.add(telefonoField);
        telefonoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));


        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            if (!nombreField.getText().trim().isBlank() || !direccionField.getText().trim().isBlank() ||
                    !telefonoField.getText().trim().isBlank()) {
                if (controller.agregarCliente(nombreField.getText().trim(),
                        direccionField.getText().trim(),
                        telefonoField.getText().trim())){
                    JOptionPane.showMessageDialog(centerPanel, "Cliente agregado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Cliente no se pudo agregar");
                }
                dispose();
            } else  {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(direccionPanel);
        centerPanel.add(telefonoPanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readCliente() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("ID del Cliente:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnSearch = new Button("Buscar");
        btnSearch.addActionListener(e -> {
            try {
                Cliente estudiante = controller.obtenerCliente(Integer.parseInt(idField.getText().trim()));
                if (estudiante != null) {
                    JOptionPane.showMessageDialog(centerPanel, estudiante.toString());
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "Cliente no encontrado");
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

    public void updateCliente() {
        setSize(500, 520);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("ID del Cliente:   "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nombrePanel.add(new JLabel("Nombre Completo:        "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel direccionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        direccionPanel.add(new JLabel("Direccion:          "));
        direccionField = new TextField(20);
        direccionPanel.add(direccionField);
        direccionPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel telefonoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        telefonoPanel.add(new JLabel("Telefonos:         "));
        telefonoField = new TextField(20);
        telefonoPanel.add(telefonoField);
        telefonoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnUpdate = new Button("Actualizar");
        btnUpdate.addActionListener(e -> {
            if (!nombreField.getText().trim().isBlank() || !direccionField.getText().trim().isBlank() ||
                    !telefonoField.getText().trim().isBlank()) {
                try {
                    if (controller.actualizarCliente(Integer.parseInt(idField.getText().trim()),
                            nombreField.getText().trim(),
                            direccionField.getText().trim(),
                            telefonoField.getText().trim())) {
                        JOptionPane.showMessageDialog(centerPanel, "Cliente actualizado con exito");
                    } else {
                        JOptionPane.showMessageDialog(centerPanel, "El Cliente no se pudo actualizar");
                    }
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(centerPanel, "Ingrese un valor entero para el ID");
                }
            } else {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(direccionPanel);
        centerPanel.add(telefonoPanel);
        southPanel.add(btnUpdate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void deleteCliente() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("ID del Cliente:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnDelete = new Button("Eliminar");
        btnDelete.addActionListener(e -> {
            try {
                if (controller.eliminarCliente(Integer.parseInt(idField.getText().trim()))) {
                    JOptionPane.showMessageDialog(centerPanel, "Cliente eliminado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Cliente no se pudo eliminar");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Ingrese un valor entero");
            }
        });

        centerPanel.add(idPanel);
        southPanel.add(btnDelete);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
}
