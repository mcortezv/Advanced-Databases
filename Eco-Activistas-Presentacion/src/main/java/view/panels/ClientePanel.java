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
    private Button btnAgregarCliente;
    private Button btnBuscarCliente;
    private Button btnActualizarCliente;
    private Button btnEliminarCliente;
    private TablePanel tablePanel;
    private MainController controller;

    public ClientePanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        updateTable();
    }

    @Override
    public void startComponents() {
        btnAgregarCliente = new Button("Agregar Cliente");
        btnBuscarCliente = new Button("Buscar Cliente");
        btnActualizarCliente = new Button("Actualizar Cliente");
        btnEliminarCliente = new Button("Eliminar Cliente");
        tablePanel = new TablePanel();
        btnAgregarCliente.setPreferredSize(new Dimension(230, 40));
        btnBuscarCliente.setPreferredSize(new Dimension(230, 40));
        btnActualizarCliente.setPreferredSize(new Dimension(230, 40));
        btnEliminarCliente.setPreferredSize(new Dimension(230, 40));
        btnAgregarCliente.addActionListener(e -> {
            new ClienteFormDialog(mainFrame, controller, 0).setVisible(true);
            updateTable();
        });
        btnBuscarCliente.addActionListener(e -> {
            new ClienteFormDialog(mainFrame, controller, 1).setVisible(true);
        });
        btnActualizarCliente.addActionListener(e -> {
            new ClienteFormDialog(mainFrame, controller, 2).setVisible(true);
            updateTable();
        });
        btnEliminarCliente.addActionListener(e -> {
            new ClienteFormDialog(mainFrame, controller, 3).setVisible(true);
            updateTable();
        });

        leftPanel.add(btnAgregarCliente);
        leftPanel.add(btnBuscarCliente);
        leftPanel.add(btnActualizarCliente);
        leftPanel.add(btnEliminarCliente);
        rightPanel.add(tablePanel);
    }

    public void updateTable() {
        tablePanel.setFullModel(TableModel.listToTableModelClientes(controller.getClienteController().listarClientes()));
    }
}
