/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;

import controllers.MainController;
import utils.TableModel;
import view.MainFrame;
import view.formsDialog.ClienteFormDialog;
import view.styles.Button;
import view.styles.Panel;

import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class ClientePanel extends Panel {
    private Button btnCreateEstudiante;
    private Button btnReadEstudiante;
    private Button btnUpdateEstudiante;
    private Button btnDeleteEstudiante;
    private TablePanel tablePanel;
    private MainController controller;

    public ClientePanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        updateTable();
    }

    @Override
    public void startComponents() {
        btnCreateEstudiante = new Button("Agregar Cliente");
        btnReadEstudiante = new Button("Buscar Cliente");
        btnUpdateEstudiante = new Button("Actualizar Cliente");
        btnDeleteEstudiante = new Button("Eliminar Cliente");
        tablePanel = new TablePanel();
        btnCreateEstudiante.setPreferredSize(new Dimension(230, 40));
        btnReadEstudiante.setPreferredSize(new Dimension(230, 40));
        btnUpdateEstudiante.setPreferredSize(new Dimension(230, 40));
        btnDeleteEstudiante.setPreferredSize(new Dimension(230, 40));
        btnCreateEstudiante.addActionListener(e -> {
            new ClienteFormDialog(mainFrame, controller, 0).setVisible(true);
            updateTable();
        });
        btnReadEstudiante.addActionListener(e -> {
            new ClienteFormDialog(mainFrame, controller, 1).setVisible(true);
        });
        btnUpdateEstudiante.addActionListener(e -> {
            new ClienteFormDialog(mainFrame, controller, 2).setVisible(true);
            updateTable();
        });
        btnDeleteEstudiante.addActionListener(e -> {
            new ClienteFormDialog(mainFrame, controller, 3).setVisible(true);
            updateTable();
        });

        leftPanel.add(btnCreateEstudiante);
        leftPanel.add(btnReadEstudiante);
        leftPanel.add(btnUpdateEstudiante);
        leftPanel.add(btnDeleteEstudiante);
        rightPanel.add(tablePanel);
    }

    public void updateTable() {
        tablePanel.setFullModel(TableModel.listToTableModelClientes(controller.getClienteController().listarClientes()));
    }
}
